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
import com.auth0.jwt.algorithms.Algorithm
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

internal class JwtProviderTest {

    @Test
    fun `should generate valid jwt token` () {
        val secret = "secret"

        val configuration = JwtConfiguration(
                issuer = "Issuer",
                audience = "Audience",
                realm = "Realm",
                ttl = -1,
                Algorithm.HMAC512(secret)
        )

        val provider = JwtProvider(configuration, DefaultExpirationDateProvider(configuration.ttl))
        val token = provider.generateToken("oauth token", 7)
        val jwt = JWT.decode(token)

        assertEquals(configuration.issuer, jwt.issuer)
    }

}