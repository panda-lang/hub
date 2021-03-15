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

package org.panda_lang.hub.github

import com.github.michaelbull.result.Ok
import com.github.michaelbull.result.Result
import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.request.header
import io.ktor.client.request.headers
import org.panda_lang.hub.failure.ErrorResponse
import org.panda_lang.hub.failure.ErrorResponseException
import org.panda_lang.hub.utils.asErr

class RemoteGitHubClient(private val httpClient: HttpClient) : GitHubClient {

    override suspend fun getProfile(token: String): Result<GitHubProfile, ErrorResponse> {
        return request("/user", token)
    }

    override suspend fun getRepositories(login: String): Result<Array<GitHubRepository>, ErrorResponse> {
        return request("/users/$login/repos")
    }

    private suspend inline fun <reified T> request(request: String): Result<T, ErrorResponse> {
        return request(request, "")
    }

    private suspend inline fun <reified T> request(request: String, token: String): Result<T, ErrorResponse> {
        return try {
            Ok(
                this.httpClient.get("https://api.github.com$request") {
                    headers {
                        header("Accept", "application/vnd.github.v3+json")

                        if (token.isNotEmpty()) {
                            header("Authorization", "token $token")
                        }
                    }
                }
            )
        } catch (errorResponseException: ErrorResponseException) {
            errorResponseException.toResponse().asErr()
        }
    }

}
