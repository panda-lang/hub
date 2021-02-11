package org.panda_lang.hub

import com.typesafe.config.ConfigFactory
import io.ktor.application.*
import io.ktor.auth.*
import io.ktor.client.*
import io.ktor.client.engine.apache.*
import io.ktor.config.*
import io.ktor.features.*
import io.ktor.locations.*
import io.ktor.request.*
import io.ktor.routing.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import io.ktor.util.*
import org.panda_lang.hub.auth.AuthEndpoint
import org.panda_lang.hub.auth.AuthService
import org.panda_lang.hub.auth.auth

const val SERVER_PORT = 8080

@KtorExperimentalAPI
val config = HoconApplicationConfig(ConfigFactory.load())

@KtorExperimentalLocationsAPI
@KtorExperimentalAPI
@EngineAPI
fun setup(): BaseApplicationEngine {
    return server(Netty)
}

@KtorExperimentalLocationsAPI
@KtorExperimentalAPI
@EngineAPI
private fun server(
    engine: ApplicationEngineFactory<BaseApplicationEngine, out ApplicationEngine.Configuration>
): BaseApplicationEngine {
    return embeddedServer(
        engine,
        port = SERVER_PORT,
        watchPaths = listOf("mainModule"),
        module = Application::mainModule
    )
}

@Location("/authorized/{type?}") class Authorized(val type: String = "")

@KtorExperimentalLocationsAPI
@KtorExperimentalAPI
fun Application.mainModule() {
    val loginProviders = listOf(
        OAuthServerSettings.OAuth2ServerSettings(
            name = "github",
            authorizeUrl = "https://github.com/login/oauth/authorize",
            accessTokenUrl = "https://github.com/login/oauth/access_token",
            clientId = config.property("github.clientId").getString(),
            clientSecret = config.property("github.clientSecret").getString(),
        )
    ).associateBy { it.name }

    install(DefaultHeaders)
    install(CallLogging)
    install(Locations)
    install(Authentication) {
        oauth {
            client = HttpClient(Apache).apply {
                environment.monitor.subscribe(ApplicationStopping) {
                    close()
                }
            }
            providerLookup = {
                loginProviders[application.locations.resolve<Authorized>(Authorized::class, this).type]
            }
            urlProvider = { url(Authorized(it.name)) }
        }
    }

    val authService = AuthService(loginProviders)

    install(Routing) {
        auth(authService, AuthEndpoint(authService))
    }
}

@KtorExperimentalLocationsAPI
private fun <T : Any> ApplicationCall.redirectUrl(t: T, secure: Boolean = true): String {
    val hostPort = request.host() + request.port().let { port -> if (port == 80) "" else ":$port" }
    val protocol = when {
        secure -> "https"
        else -> "http"
    }
    return "$protocol://$hostPort${application.locations.href(t)}"
}