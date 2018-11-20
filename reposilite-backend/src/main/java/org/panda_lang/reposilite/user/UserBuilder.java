package org.panda_lang.reposilite.user;

import org.panda_lang.reposilite.depository.AbstractDepositoryOwnerBuilder;
import org.panda_lang.reposilite.user.role.Role;
import org.panda_lang.reposilite.utils.Buildable;

import java.util.List;

public class UserBuilder extends AbstractDepositoryOwnerBuilder<UserBuilder> implements Buildable<User> {

    private String password;
    private List<Role> roles;

    public UserBuilder withPassword(String password) {
        this.password = password;
        return this;
    }

    public UserBuilder withRoles(List<Role> roles) {
        this.roles = roles;
        return this;
    }

    @Override
    public User build() {
        return new User(this.name, this.displayName, this.password, this.description, this.email, this.site, this.roles);
    }

}
