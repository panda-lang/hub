package org.panda_lang.hub.user

import io.ktor.application.*
import io.ktor.auth.*
import io.ktor.auth.jwt.*
import io.ktor.locations.*
import io.ktor.routing.*

@Location("/user")
internal class UserLocation

internal fun Routing.routes(userEndpoint: UserEndpoint) {
    authenticate("jwt") {
        location<UserLocation> {
            get {
                call.authentication.principal<JWTPrincipal>()?.let {
                    userEndpoint.user(this.context, it)
                }
            }
        }
    }
}