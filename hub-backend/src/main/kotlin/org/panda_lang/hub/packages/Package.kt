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

import kotlinx.serialization.Serializable
import org.panda_lang.hub.github.GitHubRepositoryInfo
import org.panda_lang.hub.shared.Date

typealias PackageId = String
typealias Country = String
typealias RequestsCount = Int

@Serializable
data class Package(
    val _id: PackageId,
    val repository: GitHubRepositoryInfo,
    val registeredAt: Date? = null,
    val dailyStats: List<DailyStats> = emptyList()
) {

    fun update(
        id: PackageId = this._id,
        repository: GitHubRepositoryInfo = this.repository,
        registeredAt: Date? = this.registeredAt,
        dailyStats: List<DailyStats> = this.dailyStats
    ) = Package(
        _id = id,
        repository = repository,
        registeredAt = registeredAt,
        dailyStats = dailyStats
    )

}

@Serializable
data class DailyStats(
    val date: Date = Date.now(),
    val country: Country,
    val requests: RequestsCount = 0
)
