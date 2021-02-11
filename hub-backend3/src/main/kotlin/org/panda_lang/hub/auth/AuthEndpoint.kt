package org.panda_lang.hub.auth

import io.ktor.application.*
import io.ktor.auth.*
import io.ktor.html.*
import io.ktor.locations.*
import kotlinx.html.*
import org.panda_lang.hub.Authorized

class AuthEndpoint(val authService: AuthService) {

   suspend fun login(ctx: ApplicationCall) {
      ctx.respondHtml {
         head {
            title { +"Login with" }
         }
         body {
            h1 {
               +"Login with:"
            }

            for (p in authService.loginProviders) {
               p {
                  a(href = ctx.locations.href(Authorized(p.key))) {
                     +p.key
                  }
               }
            }
         }
      }
   }

   suspend fun authorize(ctx: ApplicationCall, oauthResponse: OAuthAccessTokenResponse) {
      ctx.respondHtml {
         body {
            +"Token: $oauthResponse"
         }
      }
   }

}