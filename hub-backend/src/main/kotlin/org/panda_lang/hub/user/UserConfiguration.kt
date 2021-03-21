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

package org.panda_lang.hub.user

import io.ktor.application.Application
import io.ktor.client.HttpClient
import io.ktor.routing.Routing
import org.litote.kmongo.coroutine.CoroutineDatabase
import org.panda_lang.hub.github.GitHubClient
import org.panda_lang.hub.github.RemoteGitHubClient

fun Application.usersModule(httpClient: HttpClient, database: CoroutineDatabase): UserFacade {
    val gitHubClient = RemoteGitHubClient(httpClient)
    val collection = database.getCollection<User>()
    val repository = MongoUserRepository(collection)

    return usersModuleWithDeps(gitHubClient, repository)
}

internal fun Application.usersModuleWithDeps(gitHubClient: GitHubClient, repository: UserRepository): UserFacade {
    val userService = UserService(gitHubClient, repository)
    return UserFacade(userService)
}

fun installUserRouting(routing: Routing, userFacade: UserFacade) {
    routing.routes(userFacade)
}
