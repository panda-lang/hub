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

internal interface PackageRepository {

    suspend fun updateDailyStats(packageId: String, date: Date, dailyBulk: Map<Country, Int>)

    suspend fun savePackage(pkg: Package): Package

    suspend fun deletePackage(pkg: Package): Boolean

    suspend fun findPackageById(id: String): Package?

    suspend fun findPackageByRepositoryId(id: RepositoryId): Package?

    suspend fun findPackagesByUserId(id: String): Collection<Package>

}
