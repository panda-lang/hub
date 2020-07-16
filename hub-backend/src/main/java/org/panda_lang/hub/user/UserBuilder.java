/*
 * Copyright (c) 2018-2019 Hub Team
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

package org.panda_lang.hub.user;

import org.panda_lang.hub.user.role.Role;
import org.panda_lang.hub.utils.Buildable;

import java.util.HashSet;
import java.util.Set;

public final class UserBuilder extends Owner.AbstractProjectOwnerBuilder<UserBuilder> implements Buildable<User> {

    private String password;
    private String provider;
    private String providerId;
    private Set<Role> roles = new HashSet<>();

    protected UserBuilder() { }

    public UserBuilder withPassword(String password) {
        this.password = password;
        return this;
    }

    public UserBuilder withProvider(String provider) {
        this.provider = provider;
        return this;
    }

    public UserBuilder withProviderId(String providerId) {
        this.providerId = providerId;
        return this;
    }

    public UserBuilder withRoles(Set<Role> roles) {
        this.roles.addAll(roles);
        return this;
    }

    @Override
    public User build() {
        return new User(this.name, this.displayName, this.password, this.description, this.email, this.provider, this.providerId, this.avatar, this.site, this.roles);
    }

}
