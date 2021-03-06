package org.panda_lang.hub

import io.ktor.application.*
import io.ktor.client.*
import io.ktor.client.engine.apache.*
import io.ktor.client.features.*
import io.ktor.client.features.json.*
import io.ktor.config.*
import io.ktor.features.*
import io.ktor.http.*
import io.ktor.locations.*
import io.ktor.response.*
import io.ktor.routing.*
import io.ktor.serialization.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import kotlinx.serialization.json.Json
import org.litote.kmongo.coroutine.coroutine
import org.litote.kmongo.reactivestreams.KMongo
import org.panda_lang.hub.auth.authModule
import org.panda_lang.hub.auth.installAuthRouting
import org.panda_lang.hub.failure.failureValidator
import org.panda_lang.hub.user.installUserRouting
import org.panda_lang.hub.user.usersModule
import java.security.Security

@EngineAPI
fun main(args: Array<String>) {
    System.setProperty("io.ktor.random.secure.random.provider", "DRBG")
    Security.setProperty("securerandom.drbg.config", "HMAC_DRBG,SHA-512,256,pr_and_reseed")

    EngineMain.main(args)
}

@Suppress("unused") // linked in application.conf
fun Application.mainModule() {
    val httpClient = HttpClient(Apache) {
        install(JsonFeature) {
            accept(ContentType.Application.Json)
        }
        failureValidator()
    }

    mainModuleWithDeps(httpClient)
}

fun Application.mainModuleWithDeps(httpClient: HttpClient) {
    environment.monitor.subscribe(ApplicationStopping) {
        httpClient.close()
    }

    install(DefaultHeaders)
    install(CallLogging)
    install(Locations)
    // install(HttpsRedirect)
    // install(XForwardedHeaderSupport)
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

    val config = environment.config

    val mongoClient = KMongo.createClient(config.property("mongo.url").getString()).coroutine
    val database = mongoClient.getDatabase("hub")

    val userFacade = usersModule(httpClient, database)
    val authFacade = authModule(userFacade)

    install(Routing) {
        installUserRouting(this@mainModuleWithDeps, this, userFacade)
        installAuthRouting(this@mainModuleWithDeps, this, authFacade)
    }
}

fun ApplicationConfig.toFrontendConfiguration(): FrontendConfiguration {
    return FrontendConfiguration(
        property("frontend.url").getString(),
        property("frontend.authUrl").getString(),
    )
}