package org.panda_lang.hub.user

import io.ktor.application.*
import io.ktor.routing.*
import org.litote.kmongo.coroutine.CoroutineDatabase

fun Application.usersModule(database: CoroutineDatabase): UserFacade {
    return usersModulewithDeps(MongoUserRepository(database))
}

internal fun Application.usersModulewithDeps(repository: UserRepository): UserFacade {
    return UserFacade(repository)
}

fun installUserRouting(app: Application, routing: Routing, userFacade: UserFacade) {
    val userEndpoint = UserEndpoint(userFacade)
    routing.routes(userEndpoint)
}