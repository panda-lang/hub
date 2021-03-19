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

import org.panda_lang.hub.github.GitHubClient
import org.panda_lang.hub.github.GitHubRepository
import org.panda_lang.hub.user.UserFacade

class PackageFacade internal constructor(
    private val gitHubClient: GitHubClient,
    private val userFacade: UserFacade,
    private val packageRepository: PackageRepository
) {

    suspend fun fetchPackage(repository: GitHubRepository): Package =
        fetchAnyPackage(repository).also {
            if (!it.registered) {
                it.registered = true
                packageRepository.savePackage(it)
            }
        }

    suspend fun fetchAnyPackage(repository: GitHubRepository): Package =
        packageRepository.findPackageById(repository.id.toString()) ?: createUnregisteredPackage(repository)

    internal suspend fun createUnregisteredPackage(repository: GitHubRepository): Package =
        Package(
            _id = repository.id.toString(),
            name = repository.name,
            fullName = repository.fullName,
            owner = userFacade.getRemoteUser(repository.owner.login),
            registered = false
        )

    suspend fun getRepositories(login: String): Array<GitHubRepository> =
        gitHubClient.getRepositories(login)

    suspend fun getPackages(owner: String): Collection<Package> =
        packageRepository.findPackagesByUser(owner)

    suspend fun getPackage(owner: String, name: String): Package? =
        packageRepository.findPackageByFullName(createFullName(owner, name))

    private fun createFullName(owner: String, name: String): String = "$owner/$name"

}
