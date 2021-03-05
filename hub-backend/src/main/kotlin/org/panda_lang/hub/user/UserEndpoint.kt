package org.panda_lang.hub.user

import io.ktor.application.*
import io.ktor.auth.jwt.*
import io.ktor.response.*
import org.panda_lang.hub.auth.jwt.getIdClaim

internal class UserEndpoint(
    private val userFacade: UserFacade
) {

    suspend fun user(ctx: ApplicationCall, principal: JWTPrincipal) {
        userFacade.getUser(principal.getIdClaim())?.let { ctx.respond(it) }
    }

}