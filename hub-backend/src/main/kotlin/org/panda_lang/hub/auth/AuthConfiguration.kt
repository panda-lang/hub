/*
 * Copyright (c) 2021 Hub Team of panda-lang organization
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.panda_lang.hub.auth

import com.auth0.jwt.JWT
import com.auth0.jwt.algorithms.Algorithm
import io.ktor.application.Application
import io.ktor.application.ApplicationStopping
import io.ktor.application.install
import io.ktor.auth.Authentication
import io.ktor.auth.OAuthServerSettings
import io.ktor.auth.jwt.JWTPrincipal
import io.ktor.auth.jwt.jwt
import io.ktor.auth.oauth
import io.ktor.client.HttpClient
import io.ktor.client.engine.apache.Apache
import io.ktor.locations.locations
import io.ktor.locations.url
import io.ktor.routing.Routing
import org.panda_lang.hub.auth.jwt.DefaultExpirationDateProvider
import org.panda_lang.hub.auth.jwt.JwtConfiguration
import org.panda_lang.hub.auth.jwt.JwtProvider
import org.panda_lang.hub.toFrontendConfiguration
import org.panda_lang.hub.user.UserFacade
import java.security.SecureRandom
import java.util.concurrent.TimeUnit

fun Application.authModule(userFacade: UserFacade): AuthFacade {
    return authModuleWithDeps(userFacade)
}

fun Application.authModuleWithDeps(
    userFacade: UserFacade,
    oauthClient: HttpClient = HttpClient(Apache).apply {
        environment.monitor.subscribe(ApplicationStopping) {
            close()
        }
    },
): AuthFacade {
    val config = environment.config

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

    val loginProviders = listOf(
        OAuthServerSettings.OAuth2ServerSettings(
            name = "github",
            authorizeUrl = "https://github.com/login/oauth/authorize",
            accessTokenUrl = "https://github.com/login/oauth/access_token",
            clientId = config.property("github.clientId").getString(),
            clientSecret = config.property("github.clientSecret").getString(),
            passParamsInURL = false
        )
    ).associateBy { it.name }

    val jwtProvider = JwtProvider(jwtConfiguration, DefaultExpirationDateProvider(jwtConfiguration.ttl))
    val authService = AuthFacade(jwtProvider, userFacade)

    install(Authentication) {
        oauth("oauth") {
            client = oauthClient
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

fun installAuthRouting(app: Application, routing: Routing, authFacade: AuthFacade) =
    routing.routes(AuthEndpoint(app.environment.config.toFrontendConfiguration(), authFacade))
