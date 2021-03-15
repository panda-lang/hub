/*
 * Copyright (c) 2021 Hub Team of panda-lang organization
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.panda_lang.hub.auth

import com.github.michaelbull.result.mapBoth
import io.ktor.application.ApplicationCall
import io.ktor.auth.OAuthAccessTokenResponse
import io.ktor.http.HttpStatusCode
import io.ktor.response.respond
import io.ktor.response.respondRedirect
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
                    { error -> ctx.respond(error.status, error) }
                )
            }
            is OAuthAccessTokenResponse.OAuth1a ->
                ctx.respond(HttpStatusCode.Unauthorized, ErrorResponse(HttpStatusCode.Unauthorized, "OAuth1 is not supported"))
        }
    }

}
