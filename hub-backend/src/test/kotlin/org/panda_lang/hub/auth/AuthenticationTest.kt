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

import io.ktor.client.*
import io.ktor.client.engine.mock.*
import io.ktor.http.*
import io.ktor.server.testing.*
import org.junit.jupiter.api.Test
import org.panda_lang.hub.moduleWithDeps

class AuthenticationTest {

    private val Url.hostWithPortIfRequired: String
        get() = if (port == protocol.defaultPort) host else hostWithPort

    private val Url.fullUrl: String
        get() = "${protocol.name}://$hostWithPortIfRequired$fullPath"

    @Test
    fun `should login` () {
        val oauthHttpClient = HttpClient(MockEngine) {
            engine {
                addHandler { request ->
                    when (request.url.fullUrl) {
                        "https://example.org/" -> {
                            val responseHeaders = headersOf("Content-Type" to listOf(ContentType.Text.Plain.toString()))
                            respond("Hello, world", headers = responseHeaders)
                        }
                        else -> error("Unhandled ${request.url.fullUrl}")
                    }
                }
            }
        }

        withTestApplication {
            application.moduleWithDeps(oauthHttpClient)
        }
    }

}