package org.panda_lang.hub.user

import io.ktor.application.Application
import io.ktor.client.HttpClient
import io.ktor.routing.Routing
import org.litote.kmongo.coroutine.CoroutineDatabase
import org.panda_lang.hub.github.GitHubClient
import org.panda_lang.hub.github.RemoteGitHubClient

fun Application.usersModule(httpClient: HttpClient, database: CoroutineDatabase): UserFacade {
    return usersModulewithDeps(RemoteGitHubClient(httpClient), MongoUserRepository(database))
}

internal fun Application.usersModulewithDeps(gitHubClient: GitHubClient, repository: UserRepository): UserFacade {
    return UserFacade(gitHubClient, repository)
}

fun installUserRouting(app: Application, routing: Routing, userFacade: UserFacade) {
    val userEndpoint = UserEndpoint(userFacade)
    routing.routes(userEndpoint)
}
