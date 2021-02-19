package org.panda_lang.hub.user

import io.ktor.application.*
import io.ktor.routing.*
import org.litote.kmongo.coroutine.CoroutineDatabase

fun configureUsers(app: Application, database: CoroutineDatabase): UserFacade {
    val userRepository = UserRepository(database)
    return UserFacade(userRepository)
}

fun installUserRouting(routing: Routing, userFacade: UserFacade) {
    val userEndpoint = UserEndpoint(userFacade)
    routing.routes(userEndpoint)
}