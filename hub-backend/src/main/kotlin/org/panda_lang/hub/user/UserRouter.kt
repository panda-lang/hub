package org.panda_lang.hub.user

import io.ktor.application.call
import io.ktor.auth.authenticate
import io.ktor.auth.authentication
import io.ktor.auth.jwt.JWTPrincipal
import io.ktor.locations.Location
import io.ktor.locations.get
import io.ktor.routing.Routing

@Location("/user")
internal class UserLocation

@Location("/profile/{name}")
internal class ProfileLocation(val name: String)

internal fun Routing.routes(userEndpoint: UserEndpoint) {
    authenticate("jwt") {
        get <UserLocation> {
            call.authentication.principal<JWTPrincipal>()?.let {
                userEndpoint.user(this.context, it)
            }
        }
    }
    get <ProfileLocation> { profile ->
        userEndpoint.user(this.context, profile.name)
    }
}