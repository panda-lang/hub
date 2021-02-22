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

import io.ktor.http.*
import org.testcontainers.containers.MongoDBContainer
import org.testcontainers.junit.jupiter.Testcontainers
import org.testcontainers.utility.DockerImageName

@Testcontainers
class AuthenticationTest {

    val mongoDBContainer = MongoDBContainer(DockerImageName.parse("mongo:4.4.4"))

    private val Url.hostWithPortIfRequired: String
        get() = if (port == protocol.defaultPort) host else hostWithPort

    private val Url.fullUrl: String
        get() = "${protocol.name}://$hostWithPortIfRequired$fullPath"

    /*
    @Test
    fun `should login` () {
        val frontendConfiguration = FrontendConfiguration("", "")
        val jwtConfiguration = JwtConfiguration(null!!)
        val userRepository = UserRepository(null!!)
        val userFacade = UserFacade(userRepository)
        val authFacade = AuthFacade(jwtConfiguration, userFacade)
        val authEndpoint = AuthEndpoint(frontendConfiguration, authFacade)
        val accessToken = "secret"

        val oauthHttpClient = HttpClient(MockEngine) {
            engine {
                addHandler { request ->
                    println(request)

                    when {
                        request.url.fullUrl.startsWith(USER_INFO_URL) -> {
                            val user = GitHubUser(
                                "id",
                                "login",
                                "avatarUrl",
                                "user",
                                "name",
                                "email"
                            )

                            val responseHeaders = headersOf(
                                    Pair("Authorization", Collections.singletonList("token $accessToken")),
                                    Pair("Content-Type", Collections.singletonList(ContentType.Application.Json.contentType))
                            )

                            respond(Json.encodeToString(user), headers = responseHeaders)
                        }
                        else -> error("Unhandled ${request.url.fullUrl}")
                    }
                }
            }
        }

        withTestApplication {
            application.moduleWithDeps(oauthHttpClient)

            val response = handleRequest(HttpMethod.Get, "/authorize/github") { }

        }
    }
*/
}