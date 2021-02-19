package org.panda_lang.hub.auth

import io.ktor.application.*
import io.ktor.auth.*
import io.ktor.locations.*
import io.ktor.routing.*

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