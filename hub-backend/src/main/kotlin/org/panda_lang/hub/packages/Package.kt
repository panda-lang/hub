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
typealias Version = String

@Serializable
class Package internal constructor(
    val _id: PackageId,
    val repository: GitHubRepositoryInfo,
    val registeredAt: Date? = null,
    val dailyStats: List<DailyStats> = emptyList(),
    val totalRequests: Long = 0L
) {

    private fun copy(
        repository: GitHubRepositoryInfo = this.repository,
        registeredAt: Date? = this.registeredAt,
        dailyStats: List<DailyStats> = this.dailyStats,
        totalRequests: Long = this.totalRequests
    ) = Package(
        _id = _id,
        repository = repository,
        registeredAt = registeredAt,
        dailyStats = dailyStats,
        totalRequests = totalRequests
    )

    fun registered(date: Date = Date.now()) = copy(registeredAt = date)

    fun withUpdatedDailyStats(stats: List<DailyStats>) = copy(dailyStats = stats)

}

@Serializable
class DailyStats internal constructor(
    val date: Date = Date.now(),
    val version: Version,
    val requests: RequestsCount = 0
)
