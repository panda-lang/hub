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

import com.github.michaelbull.result.Result
import com.github.michaelbull.result.toResultOr
import io.ktor.http.*
import org.panda_lang.hub.failure.ErrorResponse
import java.util.concurrent.ConcurrentHashMap

class LocalGitHubClient : GitHubClient {

    private val profiles = ConcurrentHashMap<String, GitHubProfile>()

    init {
        profiles["localToken"] = GitHubProfile(
            id = "localId",
            login = "localLogin",
            avatarUrl = "localAvatarUrl",
            type = "localType",
            name = "localName",
            email = "localEmail"
        )
    }

    override suspend fun getProfile(token: String): Result<GitHubProfile, ErrorResponse> {
        return profiles[token].toResultOr { ErrorResponse(HttpStatusCode.NotFound, "Not found") }
    }

}