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

import io.ktor.http.HttpStatusCode
import org.panda_lang.hub.failure.ErrorResponseException
import java.util.concurrent.ConcurrentHashMap

class LocalGitHubClient : GitHubClient {

    private val profiles = ConcurrentHashMap<String, GitHubProfile>()
    private val repositories = ConcurrentHashMap<String, GitHubRepository>()

    fun registerProfile(token: String, profile: GitHubProfile) =
        profile.also { profiles[token] = it }

    override suspend fun getUser(login: String): GitHubProfile =
         profiles.values.firstOrNull { it.login == login } ?: throw ErrorResponseException(HttpStatusCode.NotFound, "Profile not found")

    override suspend fun getAuthenticatedUser(token: String): GitHubProfile =
        profiles[token] ?: throw ErrorResponseException(HttpStatusCode.NotFound, "Authenticated profile not found")

    fun registerRepository(repository: GitHubRepository) =
        repository.also { repositories[it.fullName] = it }

    override suspend fun getRepositories(login: String): Array<GitHubRepository> =
        repositories.values
            .filter { it.owner.login == login }
            .toTypedArray()

}
