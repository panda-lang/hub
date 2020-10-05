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

import io.jsonwebtoken.*
import org.panda_lang.utilities.commons.StringUtils
import org.slf4j.LoggerFactory
import org.springframework.lang.Nullable

internal class AuthenticationTokenValidator {

    companion object {
        private val LOGGER = LoggerFactory.getLogger(AuthenticationTokenValidator::class.java)
    }

    fun validate(@Nullable token: String, @Nullable secretToken: String?): Boolean {
        if (StringUtils.isEmpty(token) || StringUtils.isEmpty(secretToken)) {
            return false
        }
        try {
            Jwts.parser().setSigningKey(secretToken).parseClaimsJws(token)
            return true
        } catch (ex: SignatureException) {
            LOGGER.error("Invalid signature")
        } catch (ex: MalformedJwtException) {
            LOGGER.error("Invalid token: { token: $token, secret: $secretToken }")
        } catch (ex: ExpiredJwtException) {
            LOGGER.error("Expired token")
        } catch (ex: UnsupportedJwtException) {
            LOGGER.error("Unsupported token")
        } catch (ex: IllegalArgumentException) {
            LOGGER.error("String cannot be empty")
        }
        return false
    }
}
