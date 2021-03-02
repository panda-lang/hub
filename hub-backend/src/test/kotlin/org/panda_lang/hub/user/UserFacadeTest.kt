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

import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Test
import org.panda_lang.hub.github.GitHubUser
import kotlin.test.assertEquals
import kotlin.test.assertNull

class UserFacadeTest {

    private var userFacade = UserFacade(InMemoryUserRepository())

    @Test
    fun `given unknown id should return no value` () = runBlocking {
        assertNull(userFacade.findUserById("unknownId"))
    }

    @Test
    fun `given github profile should create and return user` () = runBlocking {
        val githubUser = GitHubUser(
                "githubId",
                "githubLogin",
                "githubAvatar",
                "githubType",
                "githubDisplayName",
                "githubEmail"
        )

        val user = userFacade.fetchUser(githubUser)

        assertEquals("githubId", user.id)
        assertEquals("githubLogin", user.username)
    }

}