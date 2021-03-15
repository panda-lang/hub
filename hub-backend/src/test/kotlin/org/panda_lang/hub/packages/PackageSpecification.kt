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
import org.panda_lang.hub.github.GitHubRepository
import org.panda_lang.hub.github.GitHubUser
import org.panda_lang.hub.github.GitHubUserType
import org.panda_lang.hub.github.LocalGitHubClient

internal open class PackageSpecification {

    private val client = LocalGitHubClient()
    internal val packageFacade = PackageFacade(client, InMemoryPackageRepository())

    init {
        val repository = GitHubRepository(
            id = 8,
            name = "localName",
            fullName = "localFullName",
            owner = GitHubUser(
                id = 7,
                login = "localLogin",
                avatarUrl = "localAvatar",
                type = GitHubUserType.USER
            )
        )

        client.registerRepository(repository)

        runBlocking {
            packageFacade.fetchPackage(repository)
        }
    }

}
