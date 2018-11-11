package org.panda_lang.reposilite.user;

import org.panda_lang.reposilite.user.role.Role;
import org.panda_lang.reposilite.utils.Buildable;

import java.util.List;

public class UserBuilder implements Buildable<User> {

    private String username;
    private String displayName;
    private String password;
    private String email;
    private List<Role> roles;

    public UserBuilder withUsername(String username) {
        this.username = username;
        return this;
    }

    public UserBuilder withDisplayName(String displayName) {
        this.displayName = displayName;
        return this;
    }

    public UserBuilder withPassword(String password) {
        this.password = password;
        return this;
    }

    public UserBuilder withEmail(String email) {
        this.email = email;
        return this;
    }

    public UserBuilder withRoles(List<Role> roles) {
        this.roles = roles;
        return this;
    }

    @Override
    public User build() {
        return new User(this.username, this.displayName, this.password, this.email, this.roles);
    }

}
