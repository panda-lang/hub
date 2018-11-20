package org.panda_lang.reposilite.organization;

import org.panda_lang.reposilite.depository.AbstractDepositoryOwnerBuilder;
import org.panda_lang.reposilite.user.User;
import org.panda_lang.reposilite.utils.Buildable;

public class OrganizationBuilder extends AbstractDepositoryOwnerBuilder<OrganizationBuilder> implements Buildable<Organization> {

    private User owner;

    public OrganizationBuilder withOwner(User owner) {
        this.owner = owner;
        return this;
    }

    @Override
    public Organization build() {
        return new Organization(this.name, this.displayName, this.description, this.email, this.site, this.owner);
    }

}
