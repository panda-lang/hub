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

import java.util.concurrent.ConcurrentHashMap

internal class InMemoryUserRepository : UserRepository {

    private val users = ConcurrentHashMap<Long, User>()

    override suspend fun findUserById(id: Long): User? {
        return users[id]
    }

    override suspend fun findUserByLogin(login: String): User? {
        return users.entries
            .firstOrNull { it.value.profile.login == login }
            ?.value
    }

    override suspend fun saveUser(user: User): User {
        users[user.id] = user
        return user
    }

}
