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

package org.panda_lang.hub.packages

import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.panda_lang.hub.github.GitHubProfile
import org.panda_lang.hub.github.GitHubRepository
import kotlin.test.assertEquals
import kotlin.test.assertNotNull
import kotlin.test.assertNull

internal class PackageFacadeTest : PackageSpecification() {

    @BeforeEach
    fun preparePackage() {
        val user = GitHubProfile(
            id = 7,
            login = "localLogin",
            avatarUrl = "localAvatar",
            type = "User",
            name = "localName",
            location = "localLocation",
            email = "localEmail",
            bio = "localBio"
        )

        val repository = GitHubRepository(
            id = 8,
            name = "localName",
            fullName = "${user.login}/localName",
            owner = user.toGitHubUserInfo()
        )

        createFetchedGitHubProfile("localToken", user)
        createFetchedGitHubRepository(repository)
    }

    @Test
    fun `should find package by name`() = runBlocking {
        // given: a valid package name
        val owner = "localLogin"
        val name = "localName"
        // when: you try to find the given package
        val pkg = packageFacade.getPackage(owner, name)
        // then: it returns a valid package
        assertNotNull(pkg)
        assertEquals(owner, pkg.owner.profile.login)
        assertEquals(name, pkg.name)
    }

    @Test
    fun `should fail for unknown name`() = runBlocking {
        // given: an unknown package name
        val owner = "unknownOwner"
        val name = "unknownName"
        // when: you try to find the given package
        val result = packageFacade.getPackage(owner, name)
        // then: result should be null
        assertNull(result)
    }

}
