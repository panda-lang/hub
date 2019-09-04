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

package org.panda_lang.reposilite.authentication.userdetails;

import java.util.Map;

class GithubOAuth2UserDetails implements OAuth2UserDetails {

    private final Map<String, Object> attributes;

    GithubOAuth2UserDetails(Map<String, Object> attributes) {
        this.attributes = attributes;
    }

    @Override
    public String getProviderId() {
        return ((Integer) this.attributes.get("id")).toString();
    }

    @Override
    public String getName() {
        return (String) this.attributes.get("login");
    }

    @Override
    public String getDisplayName() {
        return (String) this.attributes.get("name");
    }

    @Override
    public String getEmail() {
        return (String) this.attributes.get("email");
    }

    @Override
    public String getAvatar() {
        return (String) this.attributes.get("avatar_url");
    }

    @Override
    public Map<String, Object> getAttributes() {
        return this.attributes;
    }

}
