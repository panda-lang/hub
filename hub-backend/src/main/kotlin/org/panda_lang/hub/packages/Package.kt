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
import java.util.Calendar

typealias PackageId = String
typealias DateId = String
typealias Country = String
typealias RequestsCount = Int

@Serializable
data class Package(
    val _id: PackageId,
    val registered: Boolean = false,
    val repository: GitHubRepositoryInfo,
    val dailyStats: Map<DateId, DailyStats> = emptyMap()
) {

    fun toRegistered() = Package(
        _id = _id,
        registered = true,
        repository = repository
    )

}

@Serializable
data class Date(
    val year: Int,
    val month: Int,
    val day: Int
) {

    companion object {

        fun now() = Calendar.getInstance().let {
            Date(it.get(Calendar.YEAR), it.get(Calendar.MONTH), it.get(Calendar.DAY_OF_MONTH))
        }

    }

    override fun toString(): DateId = "$year-$month-$day"

}

@Serializable
data class DailyStats(
    val countries: Map<Country, RequestsCount> = emptyMap()
)
