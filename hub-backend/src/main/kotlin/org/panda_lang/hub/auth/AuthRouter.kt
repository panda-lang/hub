package org.panda_lang.hub.auth

import io.ktor.application.call
import io.ktor.auth.OAuthAccessTokenResponse
import io.ktor.auth.authenticate
import io.ktor.auth.authentication
import io.ktor.locations.Location
import io.ktor.locations.location
import io.ktor.routing.Routing
import io.ktor.routing.param

internal const val ERROR_PARAMETER = "error"

@Location("/authorize/{type?}")
internal class AuthorizeLocation(val type: String = "")

internal fun Routing.routes(authEndpoint: AuthEndpoint) {
    authenticate("oauth") {
        location <AuthorizeLocation> {
            param(ERROR_PARAMETER) {
                handle {
                    call.parameters.getAll(ERROR_PARAMETER).orEmpty()
                }
            }
            handle {
                call.authentication.principal<OAuthAccessTokenResponse>()?.let {
                    authEndpoint.authorize(this.context, it)
                }
            }
        }
    }
}
