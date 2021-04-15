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

import com.auth0.jwt.JWT
import com.auth0.jwt.algorithms.Algorithm
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

internal class JwtProviderTest {

    private val configuration = JwtConfiguration(
        issuer = "Issuer",
        audience = "Audience",
        realm = "Realm",
        ttl = -1,
        Algorithm.HMAC512("secret")
    )

    private val provider = JwtProvider(configuration, DefaultExpirationDateProvider(configuration.ttl))

    @Test
    fun `should generate valid jwt token`() {
        // given: a secret and id
        val secret = "oauth token"
        val userId = "7"
        val userLogin = "login"

        // when: provider receives request
        val token = provider.generateToken(secret, userId, userLogin)
        // then: jwt token is created
        assertTrue { token.length > secret.length }

        // when: jwt is decoded
        val jwt = JWT.decode(token)
        // then: valid data is preserved
        assertEquals(configuration.issuer, jwt.issuer)
    }

}
