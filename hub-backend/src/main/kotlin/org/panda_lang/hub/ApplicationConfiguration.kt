package org.panda_lang.hub

import com.typesafe.config.ConfigFactory
import io.ktor.application.*
import io.ktor.client.*
import io.ktor.client.engine.apache.*
import io.ktor.config.*
import io.ktor.features.*
import io.ktor.http.*
import io.ktor.locations.*
import io.ktor.routing.*
import io.ktor.serialization.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import kotlinx.serialization.json.Json
import org.litote.kmongo.coroutine.coroutine
import org.litote.kmongo.reactivestreams.KMongo
import org.panda_lang.hub.auth.configureAuthentication
import org.panda_lang.hub.auth.installAuthRouting
import org.panda_lang.hub.user.configureUsers
import org.panda_lang.hub.user.installUserRouting

const val SERVER_PORT = 8080

val config = HoconApplicationConfig(ConfigFactory.load())

val frontendConfiguration = FrontendConfiguration(
    config.property("frontend.url").getString(),
    config.property("frontend.authUrl").getString(),
)

@EngineAPI
fun setup(): BaseApplicationEngine {
    return server(Netty)
}

@EngineAPI
private fun server(
    engine: ApplicationEngineFactory<BaseApplicationEngine, out ApplicationEngine.Configuration>
): BaseApplicationEngine {
    return embeddedServer(
        engine,
        port = SERVER_PORT,
        module = Application::module,
        watchPaths = listOf("classes")
    )
}

fun Application.module() {
    val oauthHttpClient = HttpClient(Apache).apply {
        environment.monitor.subscribe(ApplicationStopping) {
            close()
        }
    }

    moduleWithDeps(oauthHttpClient)
}

fun Application.moduleWithDeps(oauthHttpClient: HttpClient) {
    install(DefaultHeaders)
    install(CallLogging)
    install(Locations)
    install(ContentNegotiation) {
        json(Json {
            prettyPrint = true
        })
    }
    install(CORS) {
        method(HttpMethod.Options)
        method(HttpMethod.Put)
        method(HttpMethod.Delete)
        method(HttpMethod.Patch)
        header(HttpHeaders.Authorization)
        allowCredentials = true
        allowNonSimpleContentTypes = true
        anyHost()
    }


    val mongoClient = KMongo.createClient(config.property("mongo.url").getString()).coroutine
    val database = mongoClient.getDatabase("hub")

    val userFacade = configureUsers(this, database)
    val authFacade = configureAuthentication(this, oauthHttpClient, userFacade)

    install(Routing) {
        installUserRouting(this, userFacade)
        installAuthRouting(this, authFacade)
    }
}