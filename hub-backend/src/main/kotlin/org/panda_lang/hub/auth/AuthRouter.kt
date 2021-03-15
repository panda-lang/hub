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
