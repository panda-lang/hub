/*
 * Copyright (c) 2018-2019 Reposilite Team
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

package org.panda_lang.reposilite.authentication;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@ConfigurationProperties(prefix = "auth")
@PropertySource("classpath:auth.properties")
class AuthenticationProperties {

    private final OAuth oauth = new OAuth();
    private final Token token = new Token();

    public OAuth getOauth() {
        return this.oauth;
    }

    public Token getToken() {
        return this.token;
    }

    public static class OAuth {

        private List<String> redirectUrls = new ArrayList<>();

        public List<String> getRedirectUrls() {
            return this.redirectUrls;
        }

        public void setRedirectUrls(List<String> redirectUrls) {
            this.redirectUrls = redirectUrls;
        }

    }

    public static class Token {

        private String secret;
        private long expiration;

        public String getSecret() {
            return this.secret;
        }

        public long getExpiration() {
            return this.expiration;
        }

        public void setSecret(String secret) {
            this.secret = secret;
        }

        public void setExpiration(long expiration) {
            this.expiration = expiration;
        }

    }

}
