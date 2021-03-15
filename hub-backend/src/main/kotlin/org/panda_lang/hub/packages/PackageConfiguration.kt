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
import org.litote.kmongo.coroutine.CoroutineDatabase
import org.panda_lang.hub.github.GitHubClient
import org.panda_lang.hub.github.RemoteGitHubClient

fun Application.packagesModule(httpClient: HttpClient, database: CoroutineDatabase): PackageFacade {
    val gitHubClient = RemoteGitHubClient(httpClient)
    val collection = database.getCollection<Package>()
    val repository = MongoPackageRepository(collection)

    return packagesModuleWithDeps(gitHubClient, repository)
}

internal fun Application.packagesModuleWithDeps(gitHubClient: GitHubClient, repository: PackageRepository): PackageFacade {
    return PackageFacade(gitHubClient, repository)
}

fun installPackageRouting(routing: Routing, packageFacade: PackageFacade) {
    val packageEndpoint = PackageEndpoint(packageFacade)
    routing.routes(packageEndpoint)
}
