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

package org.panda_lang.hub.auth.jwt

import com.auth0.jwt.JWT

const val JWT_SUBJECT = "Authentication"

class JwtProvider(private val configuration: JwtConfiguration, private val expirationDateProvider: ExpirationDateProvider) {

    fun generateToken(secret: String, userId: String): String {
        return JWT.create()
                .withSubject(JWT_SUBJECT)
                .withIssuer(configuration.issuer)
                .withAudience(configuration.audience)
                .withClaim(OAUTH2_CLAIM, secret)
                .withClaim(ID_CLAIM, userId)
                .withExpiresAt(expirationDateProvider.getValidityDate())
                .sign(configuration.algorithm)
    }

}