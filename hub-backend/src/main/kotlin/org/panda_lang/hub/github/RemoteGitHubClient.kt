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

import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.request.header
import io.ktor.client.request.headers
import java.util.concurrent.ConcurrentHashMap

class RemoteGitHubClient(private val httpClient: HttpClient) : GitHubClient {

    // TODO: Time based cache
    private val usersCache = ConcurrentHashMap<String, GitHubProfile>()
    private val usersRepositoriesCache = ConcurrentHashMap<String, Array<GitHubRepositoryInfo>>()
    private val repositoriesCache = ConcurrentHashMap<RepositoryId, GitHubRepositoryInfo>()

    override suspend fun getAuthenticatedUser(token: String): GitHubProfile =
        request("/user", token)

    override suspend fun getUser(login: String): GitHubProfile =
        usersCache[login] ?: request<GitHubProfile>("/users/$login").also {
            usersCache[login] = it
        }

    override suspend fun getRepositories(login: String): Array<GitHubRepositoryInfo> =
        usersRepositoriesCache[login] ?: request<Array<GitHubRepositoryInfo>> ("/users/$login/repos").also {
            usersRepositoriesCache[login] = it
        }

    override suspend fun getRepository(id: RepositoryId): GitHubRepositoryInfo =
        repositoriesCache[id] ?: request<GitHubRepositoryInfo>("/repos/${id.login}/${id.name}").also {
            repositoriesCache[id] = it
        }

    private suspend inline fun <reified T> request(request: String): T =
        request(request, "")

    private suspend inline fun <reified T> request(request: String, token: String): T =
        httpClient.get("https://api.github.com$request") {
            headers {
                header("Accept", "application/vnd.github.v3+json")

                if (token.isNotEmpty()) {
                    header("Authorization", "token $token")
                }
            }
        }

}
