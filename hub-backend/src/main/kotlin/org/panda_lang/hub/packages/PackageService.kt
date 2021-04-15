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
import org.panda_lang.hub.github.RepositoryId
import org.panda_lang.hub.shared.Date
import org.panda_lang.hub.user.UserFacade

internal class PackageService(
    private val gitHubClient: GitHubClient,
    private val userFacade: UserFacade,
    private val packageRepository: PackageRepository
) {

    internal suspend fun updateDailyStats(packageId: PackageId, date: Date, dailyBulk: Map<Country, Int>) =
        packageRepository.updateDailyStats(packageId, date, dailyBulk)

    suspend fun delete(repositoryId: RepositoryId): Boolean =
        getPackage(repositoryId)?.let { packageRepository.deletePackage(it) } ?: false

    suspend fun getOrFetchPackage(id: RepositoryId): Package =
        getAnyPackage(id).let {
            if (it.registeredAt == null) packageRepository.savePackage(it.registered()) else it
        }

    suspend fun getAllPackages(login: String): List<Package> =
        gitHubClient.getRepositories(login).map { repositoryInfo -> getAnyPackage(repositoryInfo.toId()) }

    private suspend fun getAnyPackage(id: RepositoryId): Package =
        packageRepository.findPackageByRepositoryId(id) ?: getRemotePackage(id)

    private suspend fun getRemotePackage(id: RepositoryId): Package =
        gitHubClient.getRepository(id).let {
            Package(
                _id = it.id.toString(),
                repository = it
            )
        }

    suspend fun getPackages(login: String): Collection<Package> =
        userFacade.getUserByLogin(login)?.let {
            packageRepository.findPackagesByUserId(it._id)
        } ?: emptyList()

    suspend fun getPackage(id: RepositoryId): Package? =
        packageRepository.findPackageByRepositoryId(id)

}
