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

import org.panda_lang.hub.utils.pollWhile
import java.util.concurrent.ConcurrentLinkedQueue

class StatsService internal constructor(private val packageService: PackageService) {

    private val cached = ConcurrentLinkedQueue<Pair<PackageId, Country>>()

    fun incrementRequestsCount(packageId: PackageId, country: Country) =
        cached.add(Pair(packageId, country))

    internal suspend fun emitCachedRequests() =
        pollRequests().forEach {
            packageService.updateDailyStats(it.key, now(), it.value)
        }

    private fun pollRequests(): Map<PackageId, Map<Country, Int>> =
        cached
            .pollWhile { cached.isNotEmpty() }
            .groupBy { it.first }
            .mapValues { (_, groupedPackages) ->
                groupedPackages
                    .groupingBy { it.second }
                    .eachCount()
            }

}
