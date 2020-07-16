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

import com.nimbusds.jose.util.JSONObjectUtils;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import net.minidev.json.JSONObject;
import org.panda_lang.hub.utils.converter.ObjectToMapConverter;
import org.springframework.security.core.Authentication;

import java.sql.Date;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.Map;

class AuthenticationTokenCreator {

    private final AuthenticationProperties authenticationProperties;
    private final ObjectToMapConverter objectToMapConverter;

    AuthenticationTokenCreator(AuthenticationProperties authenticationProperties,
            ObjectToMapConverter objectToMapConverter) {
        this.authenticationProperties = authenticationProperties;
        this.objectToMapConverter = objectToMapConverter;
    }

    String create(Authentication authentication) {
        Map<String, Object> principal = this.objectToMapConverter.convert(authentication.getPrincipal());
        LocalDate expirationDate = LocalDate.now().plusDays(this.authenticationProperties.getToken().getExpiration());

        return Jwts.builder()
                .setExpiration(Date.valueOf(expirationDate))
                .setIssuedAt(Date.valueOf(LocalDate.now()))
                .setSubject(String.valueOf(principal.get("name")))
                .signWith(SignatureAlgorithm.HS512, this.authenticationProperties.getToken().getSecret())
                .compact();
    }

    private JSONObject parsePrincipalStringToJsonObject(Object principal) {
        try {
            return JSONObjectUtils.parse(principal.toString());
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return null;
    }

}
