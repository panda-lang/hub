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

package org.panda_lang.hub.user

import com.github.michaelbull.result.Result
import com.github.michaelbull.result.map
import org.panda_lang.hub.failure.ErrorResponse
import org.panda_lang.hub.github.GitHubClient
import org.panda_lang.hub.github.GitHubProfile

class UserFacade internal constructor(
    private val gitHubClient: GitHubClient,
    private val userRepository: UserRepository
) {

    suspend fun fetchUser(token: String): Result<User, ErrorResponse> {
        return gitHubClient.getProfile(token).map { fetchUser(it) }
    }

    private suspend fun fetchUser(profile: GitHubProfile): User {
        return userRepository.findUserById(profile.id.toString()) ?: run {
            val user = User(profile.id.toString(), profile)
            return@run userRepository.saveUser(user)
        }
    }

    suspend fun getUserByLogin(login: String): User? {
        return userRepository.findUserByLogin(login)
    }

    suspend fun getUser(id: String): User? {
        return userRepository.findUserById(id)
    }

}
