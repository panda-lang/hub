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

package org.panda_lang.hub.user

import io.ktor.auth.authenticate
import io.ktor.auth.jwt.JWTPrincipal
import io.ktor.http.HttpStatusCode
import io.ktor.locations.Location
import io.ktor.locations.get
import io.ktor.routing.Routing
import org.panda_lang.hub.auth.getIdClaim
import org.panda_lang.hub.failure.ErrorResponseException
import org.panda_lang.hub.utils.orThrow
import org.panda_lang.hub.utils.principal
import org.panda_lang.hub.utils.respond

@Location("/user")
internal class UserLocation

@Location("/profile/{name}")
internal class ProfileLocation(val name: String)

internal fun Routing.routes(userFacade: UserFacade) {
    get <ProfileLocation> { profile ->
        respond {
            userFacade.getUserByLogin(profile.name)
        }.orThrow {
            ErrorResponseException(HttpStatusCode.NotFound, "User not found")
        }
    }

    authenticate("jwt") {
        get <UserLocation> {
            principal <JWTPrincipal> {
                respond {
                    userFacade.getUser(it.getIdClaim())
                }.orThrow {
                    ErrorResponseException(HttpStatusCode.NotFound, "User not found")
                }
            }
        }
    }
}
