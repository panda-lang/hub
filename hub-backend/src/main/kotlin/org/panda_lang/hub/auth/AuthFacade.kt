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

import com.github.michaelbull.result.Result
import com.github.michaelbull.result.map
import io.ktor.auth.jwt.JWTCredential
import org.panda_lang.hub.auth.jwt.JwtProvider
import org.panda_lang.hub.auth.jwt.getTokenClaim
import org.panda_lang.hub.failure.ErrorResponse
import org.panda_lang.hub.user.UserFacade
import java.util.concurrent.ConcurrentHashMap

class AuthFacade internal constructor(
    private val provider: JwtProvider,
    private val userFacade: UserFacade
) {

    private val authenticated = ConcurrentHashMap.newKeySet<String>()

    internal suspend fun authenticate(oauthToken: String): Result<AuthResponse, ErrorResponse> {
        return userFacade.fetchUser(oauthToken).map {
            val token = provider.generateToken(oauthToken, it.id)

            authenticated.add(oauthToken)
            println(token)

            return@map AuthResponse(token, it)
        }
    }

    fun invalidateToken(credential: JWTCredential) =
        authenticated.remove(credential.getTokenClaim())

    fun isAuthenticated(credential: JWTCredential): Boolean =
        authenticated.contains(credential.getTokenClaim())

}
