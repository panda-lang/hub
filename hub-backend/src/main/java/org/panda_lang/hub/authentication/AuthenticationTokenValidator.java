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

package org.panda_lang.hub.authentication;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;
import org.panda_lang.utilities.commons.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.lang.Nullable;

class AuthenticationTokenValidator {

    private static final Logger LOGGER = LoggerFactory.getLogger(AuthenticationTokenValidator.class);

    boolean validate(@Nullable String token, @Nullable String secretToken) {
        if (StringUtils.isEmpty(token) || StringUtils.isEmpty(secretToken)) {
            return false;
        }

        try {
            Jwts.parser().setSigningKey(secretToken).parseClaimsJws(token);
            return true;
        } catch (SignatureException ex) {
            LOGGER.error("Invalid signature");
        } catch (MalformedJwtException ex) {
            LOGGER.error("Invalid token: { token: " + token + ", secret: " + secretToken + " }");
        } catch (ExpiredJwtException ex) {
            LOGGER.error("Expired token");
        } catch (UnsupportedJwtException ex) {
            LOGGER.error("Unsupported token");
        } catch (IllegalArgumentException ex) {
            LOGGER.error("String cannot be empty");
        }

        return false;
    }

}