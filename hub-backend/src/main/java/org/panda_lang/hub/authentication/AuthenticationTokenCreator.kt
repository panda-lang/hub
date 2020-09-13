/*
 * Copyright (c) 2020 Hub Team of panda-lang organization
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
package org.panda_lang.hub.authentication

import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import org.panda_lang.hub.utils.converter.ObjectToMapConverter
import org.springframework.security.core.Authentication
import java.sql.Date
import java.time.LocalDate

internal class AuthenticationTokenCreator(
        private val authenticationProperties: AuthenticationProperties,
        private val objectToMapConverter: ObjectToMapConverter
) {

    fun create(authentication: Authentication): String {
        val principal = objectToMapConverter.convert(authentication.principal)
        val expirationDate = LocalDate.now().plusDays(authenticationProperties.token.expiration)

        return Jwts.builder()
                .setExpiration(Date.valueOf(expirationDate))
                .setIssuedAt(Date.valueOf(LocalDate.now()))
                .setSubject(principal["name"].toString())
                .signWith(SignatureAlgorithm.HS512, authenticationProperties.token.secret)
                .compact()
    }

}