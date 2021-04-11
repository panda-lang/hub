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

import io.ktor.application.Application
import io.ktor.client.HttpClient
import io.ktor.routing.Routing
import kotlinx.coroutines.runBlocking
import org.litote.kmongo.coroutine.CoroutineDatabase
import org.panda_lang.hub.github.GitHubClient
import org.panda_lang.hub.github.RemoteGitHubClient
import org.panda_lang.hub.user.UserFacade
import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit

const val EMIT_STATS_DELAY_IN_SECONDS = 10L

private val SCHEDULER = Executors.newSingleThreadScheduledExecutor()

fun Application.packagesModule(httpClient: HttpClient, userFacade: UserFacade, database: CoroutineDatabase): PackageFacade {
    val gitHubClient = RemoteGitHubClient(httpClient)

    val packageCollection = database.getCollection<Package>()
    val packageRepository = MongoPackageRepository(packageCollection)

    return packagesModuleWithDeps(gitHubClient, userFacade, packageRepository)
}

internal fun Application.packagesModuleWithDeps(
    gitHubClient: GitHubClient,
    userFacade: UserFacade,
    packageRepository: PackageRepository,
): PackageFacade {
    val packageService = PackageService(gitHubClient, userFacade, packageRepository)
    val statsService = StatsService(packageService)

    SCHEDULER.scheduleWithFixedDelay(
        {
            runBlocking {
                statsService.emitCachedRequests()
            }
        },
        EMIT_STATS_DELAY_IN_SECONDS, EMIT_STATS_DELAY_IN_SECONDS, TimeUnit.SECONDS
    )

    return PackageFacade(packageService, statsService)
}

fun installPackageRouting(routing: Routing, packageFacade: PackageFacade) {
    routing.routes(packageFacade)
}
