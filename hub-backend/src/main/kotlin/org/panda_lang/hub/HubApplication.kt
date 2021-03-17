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

package org.panda_lang.hub

import io.ktor.application.Application
import io.ktor.application.ApplicationStopping
import io.ktor.application.call
import io.ktor.application.install
import io.ktor.client.HttpClient
import io.ktor.client.engine.apache.Apache
import io.ktor.client.features.json.JsonFeature
import io.ktor.client.features.json.serializer.KotlinxSerializer
import io.ktor.config.ApplicationConfig
import io.ktor.features.CORS
import io.ktor.features.CallLogging
import io.ktor.features.ContentNegotiation
import io.ktor.features.DefaultHeaders
import io.ktor.features.StatusPages
import io.ktor.http.ContentType
import io.ktor.http.HttpHeaders
import io.ktor.http.HttpMethod
import io.ktor.locations.Locations
import io.ktor.response.respond
import io.ktor.routing.Routing
import io.ktor.serialization.json
import io.ktor.server.engine.EngineAPI
import io.ktor.server.netty.EngineMain
import kotlinx.coroutines.runBlocking
import kotlinx.serialization.json.Json
import org.litote.kmongo.coroutine.coroutine
import org.litote.kmongo.id.serialization.IdKotlinXSerializationModule
import org.litote.kmongo.reactivestreams.KMongo
import org.panda_lang.hub.auth.authModule
import org.panda_lang.hub.auth.installAuthRouting
import org.panda_lang.hub.failure.ErrorResponseException
import org.panda_lang.hub.failure.failureValidator
import org.panda_lang.hub.packages.installPackageRouting
import org.panda_lang.hub.packages.packagesModule
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
    val json = Json {
        ignoreUnknownKeys = true
        prettyPrint = true
        serializersModule = IdKotlinXSerializationModule
    }

    val httpClient = HttpClient(Apache) {
        install(JsonFeature) {
            serializer = KotlinxSerializer(json)
            accept(ContentType.Application.Json)
        }
        failureValidator()
    }

    mainModuleWithDeps(json, httpClient)
}

fun Application.mainModuleWithDeps(json: Json, httpClient: HttpClient) {
    environment.monitor.subscribe(ApplicationStopping) {
        httpClient.close()
    }

    install(DefaultHeaders)
    install(CallLogging)
    install(Locations)
    install(ContentNegotiation) {
        json(json)
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
    install(StatusPages) {
        exception<ErrorResponseException> { cause ->
            call.respond(cause.response.status, cause.response)
        }
    }

    val config = environment.config

    val mongoClient = KMongo.createClient(config.property("mongo.url").getString()).coroutine
    val database = mongoClient.getDatabase("hub")
    runBlocking { database.drop() }

    val userFacade = usersModule(httpClient, database)
    val packageFacade = packagesModule(httpClient, userFacade, database)
    val authFacade = authModule(userFacade)

    install(Routing) {
        installUserRouting(this, userFacade)
        installPackageRouting(this, packageFacade)
        installAuthRouting(this@mainModuleWithDeps, this, authFacade)
    }
}

fun ApplicationConfig.toFrontendConfiguration(): FrontendConfiguration {
    return FrontendConfiguration(
        property("frontend.url").getString(),
        property("frontend.authUrl").getString(),
    )
}
