package org.panda_lang.hub.auth

import io.ktor.application.*
import io.ktor.auth.*
import io.ktor.locations.*
import io.ktor.routing.*

@KtorExperimentalLocationsAPI
fun Routing.auth(authService: AuthService, authEndpoint: AuthEndpoint) {
    route("login") {
        get { authEndpoint.login(this.context) }
    }
    authenticate {
        route("/authorized/{type}") {
            param("error") {
                handle {
                    call.parameters.getAll("error").orEmpty()
                }
            }
            handle {
                val principal = call.authentication.principal<OAuthAccessTokenResponse>()

                if (principal != null) {
                    authEndpoint.authorize(this.context, principal)
                }
                else {
                    // idk
                }
            }
        }
    }

}