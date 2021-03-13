package org.panda_lang.hub.user

import io.ktor.application.ApplicationCall
import io.ktor.auth.jwt.JWTPrincipal
import io.ktor.response.respond
import org.panda_lang.hub.auth.jwt.getIdClaim

internal class UserEndpoint(
    private val userFacade: UserFacade
) {

    suspend fun user(ctx: ApplicationCall, principal: JWTPrincipal) {
        userFacade.getUser(principal.getIdClaim())?.let { ctx.respond(it) }
    }

    suspend fun user(ctx: ApplicationCall, login: String) {
        userFacade.getUser(login)?.let { ctx.respond(it) }
    }

}
