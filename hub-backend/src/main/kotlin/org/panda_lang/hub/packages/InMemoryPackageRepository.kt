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
import org.panda_lang.hub.shared.Date
import org.panda_lang.hub.shared.paging.Page
import org.panda_lang.hub.shared.paging.page
import org.panda_lang.hub.user.UserId
import org.panda_lang.hub.utils.mapOnly
import java.util.concurrent.ConcurrentHashMap

internal class InMemoryPackageRepository : PackageRepository {

    private val packages = ConcurrentHashMap<PackageId, Package>()

    override suspend fun findLatest(page: Int, pageSize: Int): Page<Package> = packages.values
        .sortedBy { it.registeredAt.toString() }
        .page(page, pageSize, packages.size)

    override suspend fun findPopular(page: Int, pageSize: Int): Page<Package> = packages.values
        .sortedBy { it.dailyStats.sumBy { daily -> daily.requests } }
        .page(page, pageSize, packages.size)

    override suspend fun findTrending(page: Int, pageSize: Int): Page<Package> = packages.values
        .sortedBy { pkg ->
            val byDates = pkg.dailyStats.groupBy { dailyStats -> dailyStats.date }
            val todayCount = byDates[Date.now()]?.sumBy { it.requests } ?: 0
            val yesterdayCount = byDates[Date.yesterday()]?.sumBy { it.requests } ?: 0
            todayCount - yesterdayCount
        }
        .page(page, pageSize, packages.size)

    override suspend fun updateDailyStats(packageId: PackageId, date: Date, dailyBulk: Map<Country, Int>) =
        packages[packageId]!!.let { pkg ->
            packages[packageId] = pkg.update(
                dailyStats = pkg.dailyStats.mapOnly(
                    { it.date == date },
                    { daily -> DailyStats(date, daily.country, daily.requests + (dailyBulk[daily.country] ?: 0)) }
                )
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
