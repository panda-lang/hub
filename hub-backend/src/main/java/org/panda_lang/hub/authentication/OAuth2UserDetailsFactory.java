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

import java.util.Map;

public final class OAuth2UserDetailsFactory {

    private OAuth2UserDetailsFactory() {}

    public static OAuth2UserDetails obtainOAuth2UserDetails(String providerName, Map<String, Object> attributes) {
        if ("github".equalsIgnoreCase(providerName)) {
            return new GithubOAuth2UserDetails(attributes);
        }
        else {
            throw new UnsupportedOperationException();
        }
    }

}
