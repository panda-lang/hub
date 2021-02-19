package org.panda_lang.hub.auth

import com.auth0.jwt.JWT
import com.auth0.jwt.algorithms.Algorithm
import io.ktor.application.*
import io.ktor.auth.*
import io.ktor.auth.jwt.*
import io.ktor.client.*
import io.ktor.client.engine.apache.*
import io.ktor.locations.*
import io.ktor.routing.*
import org.panda_lang.hub.config
import org.panda_lang.hub.frontendConfiguration
import org.panda_lang.hub.user.UserFacade
import java.security.SecureRandom
import java.util.concurrent.TimeUnit

internal val loginProviders = listOf(
    OAuthServerSettings.OAuth2ServerSettings(
        name = "github",
        authorizeUrl = "https://github.com/login/oauth/authorize",
        accessTokenUrl = "https://github.com/login/oauth/access_token",
        clientId = config.property("github.clientId").getString(),
        clientSecret = config.property("github.clientSecret").getString(),
        passParamsInURL = false
    )
).associateBy { it.name }

fun configureAuthentication(app: Application, userFacade: UserFacade): AuthFacade {
    val secureRandom = SecureRandom()
    val jwtSecret = ByteArray(512)
    secureRandom.nextBytes(jwtSecret)

    val jwtConfiguration = JwtConfiguration(
        config.property("jwt.issuer").getString(),
        config.property("jwt.audience").getString(),
        config.property("jwt.realm").getString(),
        TimeUnit.DAYS.toMillis(config.property("jwt.ttl").getString().toLong()),
        Algorithm.HMAC512("2137")
    )

    val authService = AuthFacade(jwtConfiguration, userFacade)

    app.install(Authentication) {
        oauth("oauth") {
            client = HttpClient(Apache).apply {
                app.environment.monitor.subscribe(ApplicationStopping) {
                    close()
                }
            }
            providerLookup = {
                loginProviders[application.locations.resolve<AuthorizeLocation>(AuthorizeLocation::class, this).type]
            }
            urlProvider = { url(AuthorizeLocation(it.name)) }
        }
        jwt("jwt") {
            realm = jwtConfiguration.realm
            verifier(
                JWT.require(jwtConfiguration.algorithm)
                    .withIssuer(jwtConfiguration.issuer)
                    .withAudience(jwtConfiguration.audience)
                    .build()
            )
            validate { jwtCredential ->
                if (authService.isAuthenticated(jwtCredential))
                    JWTPrincipal(jwtCredential.payload)
                else null
            }
        }
    }

    return authService
}

fun installAuthRouting(routing: Routing, authFacade: AuthFacade) {
    val authEndpoint = AuthEndpoint(frontendConfiguration, authFacade)
    routing.routes(authEndpoint)
}