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
typealias DateString = String
typealias Country = String

@Serializable
data class Package(
    val _id: PackageId,
    val registered: Boolean = false,
    val repository: GitHubRepositoryInfo,
    val dailyStats: Map<DateString, DailyStats> = HashMap()
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

    override fun toString(): DateString = "$year-$month-$day"

}

fun now(): Date {
    val calendar = Calendar.getInstance()
    return Date(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH))
}

@Serializable
data class DailyStats(
    val countries: Map<Country, CountryRecord> = emptyMap()
)

@Serializable
data class CountryRecord(
    val requests: Int = 0
)
