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
import java.util.concurrent.ConcurrentHashMap

internal class InMemoryPackageRepository : PackageRepository {

    private val packages = ConcurrentHashMap<String, Package>()

    override suspend fun savePackage(pkg: Package): Package =
        pkg.also { packages[it._id] = it }

    override suspend fun deletePackage(pkg: Package): Boolean =
        packages.remove(pkg._id).let { true }

    override suspend fun findPackageById(id: String): Package? =
        packages[id]

    override suspend fun findPackageByRepositoryId(id: RepositoryId): Package? =
        packages.values.firstOrNull { it.fullName == id.fullName() }

    override suspend fun findPackagesByUserId(id: String): Collection<Package> =
        packages.values.filter { it.ownerId == id }

}
