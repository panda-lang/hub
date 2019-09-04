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

package org.panda_lang.reposilite.organization;

import org.panda_lang.reposilite.depository.AbstractDepositoryOwnerBuilder;
import org.panda_lang.reposilite.user.User;
import org.panda_lang.reposilite.utils.Buildable;

final class OrganizationBuilder extends AbstractDepositoryOwnerBuilder<OrganizationBuilder> implements Buildable<Organization> {

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
