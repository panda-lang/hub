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
import org.panda_lang.hub.user.UserId
import java.util.concurrent.ConcurrentHashMap

internal class InMemoryPackageRepository : PackageRepository {

    private val packages = ConcurrentHashMap<PackageId, Package>()

    override suspend fun updateDailyStats(packageId: PackageId, date: Date, dailyBulk: Map<Country, Int>) =
        packages[packageId]!!.let {
            packages[packageId] = Package(
                _id = it._id,
                registered = it.registered,
                repository = it.repository,
                dailyStats = HashMap(it.dailyStats).also { updatedStats ->
                    updatedStats[date.toString()] = ((updatedStats[date.toString()] ?: DailyStats()).countries.asSequence() + dailyBulk.asSequence())
                        .groupBy({ entry -> entry.key }, { entry -> entry.value })
                        .mapValues { entry -> entry.value.sum() }
                        .let { map -> DailyStats(map) }
                }
            )
        }

    override suspend fun savePackage(pkg: Package): Package =
        pkg.also { packages[it._id] = it }

    override suspend fun deletePackage(pkg: Package): Boolean =
        packages.remove(pkg._id).let { true }

    override suspend fun findPackageById(id: PackageId): Package? =
        packages[id]

    override suspend fun findPackageByRepositoryId(id: RepositoryId): Package? =
        packages.values.firstOrNull { it.repository.fullName == id.fullName() }

    override suspend fun findPackagesByUserId(id: UserId): Collection<Package> =
        packages.values.filter { it.repository.owner.id == id.toLong() }

}
