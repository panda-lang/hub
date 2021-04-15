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

import org.litote.kmongo.and
import org.litote.kmongo.coroutine.CoroutineCollection
import org.litote.kmongo.div
import org.litote.kmongo.eq
import org.litote.kmongo.inc
import org.litote.kmongo.upsert
import org.panda_lang.hub.github.GitHubRepositoryInfo
import org.panda_lang.hub.github.GitHubUserInfo
import org.panda_lang.hub.github.RepositoryId
import org.panda_lang.hub.shared.Date
import org.panda_lang.hub.shared.paging.Page
import org.panda_lang.hub.shared.paging.page
import org.panda_lang.hub.user.UserId
import org.panda_lang.hub.utils.page
import org.panda_lang.hub.utils.posOp

internal class MongoPackageRepository(private val collection: CoroutineCollection<Package>) : PackageRepository {

    override suspend fun findLatest(page: Int, pageSize: Int): Page<Package> =
        collection.find()
            .ascendingSort(Package::registeredAt)
            .page(collection, page, pageSize)

    override suspend fun findPopular(page: Int, pageSize: Int): Page<Package> =
        collection.find()
            // TODO: Some kind of aggregation query XD
            .toList()
            .sortedBy { pkg -> pkg.dailyStats.sumBy { it.requests } }
            .page(page, pageSize, collection.countDocuments())

    @Suppress("DuplicatedCode") // from in memory impl
    override suspend fun findTrending(page: Int, pageSize: Int): Page<Package> =
        // TODO: Some kind of aggregation query XD
        collection.find()
            .toList()
            .sortedBy { pkg ->
                val byDates = pkg.dailyStats.groupBy { dailyStats -> dailyStats.date }
                val todayCount = byDates[Date.now()]?.sumBy { it.requests } ?: 0
                val yesterdayCount = byDates[Date.yesterday()]?.sumBy { it.requests } ?: 0
                todayCount - yesterdayCount
            }
            .page(page, pageSize, collection.countDocuments())

    override suspend fun updateDailyStats(packageId: PackageId, date: Date, dailyBulk: Map<Country, Int>) =
        dailyBulk.forEach {
            collection.updateOneById(
                and(Package::_id eq packageId, Package::dailyStats / DailyStats::date eq date, Package::dailyStats / DailyStats::country eq it.key),
                inc(Package::dailyStats.posOp / DailyStats::requests, it.value),
                upsert()
            )
        }

    override suspend fun savePackage(pkg: Package): Package =
        pkg.also { collection.insertOne(it) }

    override suspend fun deletePackage(pkg: Package): Boolean =
        collection.deleteOneById(pkg._id).wasAcknowledged()

    override suspend fun findPackageById(id: PackageId): Package? =
        collection.findOne(Package::_id eq id)

    override suspend fun findPackageByRepositoryId(id: RepositoryId): Package? =
        collection.findOne(Package::repository / GitHubRepositoryInfo::fullName eq id.fullName())

    override suspend fun findPackagesByUserId(id: UserId): Collection<Package> =
        collection.find(Package::repository / GitHubRepositoryInfo::owner / GitHubUserInfo::id eq id.toLong()).toList()

}
