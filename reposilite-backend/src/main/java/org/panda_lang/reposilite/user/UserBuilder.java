package org.panda_lang.reposilite.user;

import org.panda_lang.reposilite.depository.AbstractDepositoryOwnerBuilder;
import org.panda_lang.reposilite.user.role.Role;
import org.panda_lang.reposilite.utils.Buildable;

import java.util.Set;

public final class UserBuilder extends AbstractDepositoryOwnerBuilder<UserBuilder> implements Buildable<User> {

    private String password;
    private String provider;
    private String providerId;
    private Set<Role> roles;

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
        this.roles = roles;
        return this;
    }

    @Override
    public User build() {
        return new User(this.name, this.displayName, this.password, this.description, this.email, this.provider, this.providerId, this.avatar, this.site, this.roles);
    }

}
