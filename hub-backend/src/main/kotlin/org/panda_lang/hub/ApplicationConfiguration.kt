package org.panda_lang.hub

import com.typesafe.config.ConfigFactory
import io.ktor.application.*
import io.ktor.config.*
import io.ktor.features.*
import io.ktor.http.*
import io.ktor.locations.*
import io.ktor.routing.*
import io.ktor.serialization.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import kotlinx.serialization.json.Json
import org.panda_lang.hub.auth.*
import org.litote.kmongo.reactivestreams.*
import org.litote.kmongo.coroutine.*
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
    val authFacade = configureAuthentication(this, userFacade)

    install(Routing) {
        installUserRouting(this, userFacade)
        installAuthRouting(this, authFacade)
    }
}