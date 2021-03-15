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

import com.github.michaelbull.result.Result
import org.panda_lang.hub.failure.ErrorResponse
import org.panda_lang.hub.github.GitHubClient
import org.panda_lang.hub.github.GitHubRepository
import org.panda_lang.hub.user.UserFacade

class PackageFacade internal constructor(
    private val gitHubClient: GitHubClient,
    private val userFacade: UserFacade,
    private val packageRepository: PackageRepository
) {

    suspend fun fetchPackage(repository: GitHubRepository): Package {
        return packageRepository.findPackageById(repository.id.toString()) ?: run {
            return@run packageRepository.savePackage(
                Package(
                    _id = repository.id.toString(),
                    name = repository.name,
                    fullName = repository.fullName,
                    owner = userFacade.getUser(repository.owner.id.toString())!!,
                    registered = true
                )
            )
        }
    }

    suspend fun getRepositories(login: String): Result<Array<GitHubRepository>, ErrorResponse> {
        return gitHubClient.getRepositories(login)
    }

    suspend fun getPackages(owner: String): Collection<Package> {
        return packageRepository.findPackagesByUser(owner)
    }

    suspend fun getPackage(owner: String, name: String): Package? {
        return packageRepository.findPackageByFullName(getFullName(owner, name))
    }

    fun getFullName(owner: String, name: String): String {
        return "$owner/$name"
    }

}
