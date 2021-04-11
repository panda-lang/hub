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

import org.panda_lang.hub.github.RepositoryId

class PackageFacade internal constructor(
    private val packageService: PackageService,
    private val statsService: StatsService
) {

    suspend fun incrementRequestsCount(packageId: String, country: Country) =
        statsService.incrementRequestsCount(packageId, country)

    suspend fun deletePackage(login: String, name: String): Boolean =
        packageService.delete(RepositoryId(login, name))

    suspend fun getOrFetchPackage(login: String, name: String): Package =
        packageService.getOrFetchPackage(RepositoryId(login, name))

    suspend fun getPackage(login: String, name: String): Package? =
        packageService.getPackage(RepositoryId(login, name))

    suspend fun getAllPackages(login: String): List<Package> =
        packageService.getAllPackages(login)

    suspend fun getPackages(login: String): Collection<Package> =
        packageService.getPackages(login)

}
