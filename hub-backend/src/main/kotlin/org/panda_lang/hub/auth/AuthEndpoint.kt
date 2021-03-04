package org.panda_lang.hub.auth

import io.ktor.application.*
import io.ktor.auth.*
import io.ktor.http.*
import io.ktor.response.*
import org.panda_lang.hub.ErrorResponse
import org.panda_lang.hub.FrontendConfiguration

internal class AuthEndpoint(
   private val frontendConfiguration: FrontendConfiguration,
   private val authFacade: AuthFacade
) {

   suspend fun authorize(ctx: ApplicationCall, oauthResponse: OAuthAccessTokenResponse) {
      when (oauthResponse) {
         is OAuthAccessTokenResponse.OAuth2 -> {
            val response = authFacade.authenticate(oauthResponse.accessToken)
            ctx.respondRedirect("${frontendConfiguration.authUrl}/?token=${response.jwt}")
         }
         is OAuthAccessTokenResponse.OAuth1a ->
            ctx.respond(HttpStatusCode.Unauthorized, ErrorResponse("OAuth1 is not supported"))
      }
   }

}