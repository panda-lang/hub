package org.panda_lang.hub.user

import io.ktor.application.*
import io.ktor.auth.jwt.*
import io.ktor.response.*
import org.panda_lang.hub.auth.jwt.ID_CLAIM

internal class UserEndpoint(
    private val userFacade: UserFacade
) {

    suspend fun user(ctx: ApplicationCall, jwtPrincipal: JWTPrincipal) {
        ctx.respond(userFacade.findUserById(jwtPrincipal.payload.getClaim(ID_CLAIM).asString()))
    }

}