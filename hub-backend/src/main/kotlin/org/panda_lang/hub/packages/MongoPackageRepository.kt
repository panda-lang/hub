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

import org.litote.kmongo.coroutine.CoroutineCollection
import org.litote.kmongo.div
import org.litote.kmongo.eq
import org.litote.kmongo.upsert
import org.panda_lang.hub.github.GitHubRepositoryInfo
import org.panda_lang.hub.github.GitHubUserInfo
import org.panda_lang.hub.github.RepositoryId

internal class MongoPackageRepository(private val collection: CoroutineCollection<Package>) : PackageRepository {

    override suspend fun updateDailyStats(packageId: String, date: Date, dailyBulk: Map<Country, Int>) =
        dailyBulk.forEach {
            collection.updateOneById(
                packageId,
                // Missing support for key projection in KMongo
                // ~ https://github.com/Litote/kmongo/issues/273
                "{ \$inc: { 'dailyStats.$date.countries.${it.key}.requests': ${it.value} } }",
                upsert()
            )
        }

    override suspend fun savePackage(pkg: Package): Package =
        pkg.also { collection.insertOne(it) }

    override suspend fun deletePackage(pkg: Package): Boolean =
        collection.deleteOneById(pkg._id).wasAcknowledged()

    override suspend fun findPackageById(id: String): Package? =
        collection.findOne(Package::_id eq id)

    override suspend fun findPackageByRepositoryId(id: RepositoryId): Package? =
        collection.findOne(Package::repository / GitHubRepositoryInfo::fullName eq id.fullName())

    override suspend fun findPackagesByUserId(id: String): Collection<Package> =
        collection.find(Package::repository / GitHubRepositoryInfo::owner / GitHubUserInfo::id eq id.toLong()).toList()

}
