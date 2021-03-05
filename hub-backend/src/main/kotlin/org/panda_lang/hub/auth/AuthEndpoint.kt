package org.panda_lang.hub.auth

import com.github.michaelbull.result.mapBoth
import io.ktor.application.*
import io.ktor.auth.*
import io.ktor.http.*
import io.ktor.response.*
import org.panda_lang.hub.FrontendConfiguration
import org.panda_lang.hub.failure.ErrorResponse

internal class AuthEndpoint(
   private val frontendConfiguration: FrontendConfiguration,
   private val authFacade: AuthFacade
) {

   suspend fun authorize(ctx: ApplicationCall, oauthResponse: OAuthAccessTokenResponse) {
      when (oauthResponse) {
         is OAuthAccessTokenResponse.OAuth2 -> {
            authFacade.authenticate(oauthResponse.accessToken).mapBoth(
                { response -> ctx.respondRedirect("${frontendConfiguration.authUrl}/?token=${response.jwt}") },
                { error -> ctx.respond(HttpStatusCode.fromValue(error.status), error) }
             )
         }
         is OAuthAccessTokenResponse.OAuth1a ->
            ctx.respond(HttpStatusCode.Unauthorized, ErrorResponse(HttpStatusCode.Unauthorized.value, "OAuth1 is not supported"))
      }
   }

}