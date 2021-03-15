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

import com.github.michaelbull.result.get
import com.github.michaelbull.result.getError
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.panda_lang.hub.github.GitHubProfile
import org.panda_lang.hub.github.GitHubUserType
import kotlin.test.assertEquals
import kotlin.test.assertNull

internal class UserFacadeTest : UserSpecification() {

    @BeforeEach
    fun prepareProfile() {
        val profile = GitHubProfile(
            id = 7,
            login = "localLogin",
            avatarUrl = "localAvatarUrl",
            type = GitHubUserType.USER,
            name = "localName",
            location = "localLocation",
            email = "localEmail",
            bio = "localBio"
        )

        createFetchedGitHubProfile("localToken", profile)
    }

    @Test
    fun `should fetch profile by valid token `() = runBlocking {
        // given: a valid token
        val token = "localToken"
        // when: you request user associated with the given token
        val user = userFacade.fetchUser(token).get()!!
        // then: it should return valid user
        assertEquals(7, user.id)
        assertEquals("localLogin", user.profile.login)
    }

    @Test
    fun `should fail for unknown token`() = runBlocking {
        // given: an unknown token
        val invalidToken = "unknownToken"
        // when: you try to fetch associated user
        val fetchResult = userFacade.fetchUser(invalidToken)
        // then: it should return error (404) response
        val error = fetchResult.getError()!!
        assertEquals(404, error.status.value)
    }

    @Test
    fun `should fail for unknown id`() = runBlocking {
        // given: unknown id
        val unknownId = -1L
        // when: you try to get user
        val user = userFacade.getUser(unknownId)
        // then: result should not contain user
        assertNull(user)
    }

    @Test
    fun `should find by login`() = runBlocking {
        // given: token and login
        val login = "localLogin"
        // when: you try to get the given user
        val user = userFacade.getUser(login)
        // then: result should contain requested user
        assertEquals(7, user!!.id)
    }

    @Test
    fun `should fail for unknown login`() = runBlocking {
        // given: unknown login
        val invalidLogin = "unknownLogin"
        // when: user is requested
        val user = userFacade.getUser(invalidLogin)
        // then: result should not contain user
        assertNull(user)
    }

}
