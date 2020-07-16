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

package org.panda_lang.hub.organization;

import org.panda_lang.hub.user.Owner.AbstractProjectOwnerBuilder;
import org.panda_lang.hub.user.User;
import org.panda_lang.hub.utils.Buildable;

final class OrganizationBuilder extends AbstractProjectOwnerBuilder<OrganizationBuilder> implements Buildable<Organization> {

    private User owner;

    public OrganizationBuilder withOwner(User owner) {
        this.owner = owner;
        return this;
    }

    @Override
    public Organization build() {
        return new Organization(this.name, this.displayName, this.description, this.email, this.avatar, this.site, this.owner);
    }

}
