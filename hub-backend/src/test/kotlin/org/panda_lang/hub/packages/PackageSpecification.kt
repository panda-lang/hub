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
import org.panda_lang.hub.github.GitHubRepositoryInfo
import org.panda_lang.hub.github.LocalGitHubClient
import org.panda_lang.hub.user.UserSpecification

open class PackageSpecification : UserSpecification() {

    private val client = LocalGitHubClient()
    private val packageService = PackageService(client, userFacade, InMemoryPackageRepository())

    internal val packageFacade = PackageFacade(packageService)

    fun createGitHubRepository(repository: GitHubRepositoryInfo) =
        client.registerRepository(repository)

    fun createFetchedGitHubRepository(repository: GitHubRepositoryInfo) = runBlocking {
        createGitHubRepository(repository)
        packageFacade.fetchPackage(repository.owner.login, repository.name)
    }

}
