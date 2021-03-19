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

import org.litote.kmongo.coroutine.CoroutineCollection
import org.litote.kmongo.div
import org.litote.kmongo.eq
import org.panda_lang.hub.github.GitHubProfile

internal class MongoUserRepository(private val collection: CoroutineCollection<User>) : UserRepository {

    override suspend fun saveUser(user: User): User =
        user.also { collection.insertOne(it) }

    override suspend fun findUserById(id: String): User? =
        collection.findOne(User::_id eq id)

    override suspend fun findUserByLogin(login: String): User? =
        collection.findOne(User::profile / GitHubProfile::login eq login)

}
