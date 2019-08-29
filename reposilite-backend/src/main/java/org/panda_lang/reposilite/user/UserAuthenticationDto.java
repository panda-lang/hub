package org.panda_lang.reposilite.user;

import org.panda_lang.reposilite.utils.entity.AbstractDto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class UserAuthenticationDto extends AbstractDto<User> {

    @NotNull @NotEmpty
    private String username;

    @NotNull @NotEmpty
    private String password;

    public UserAuthenticationDto(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public UserAuthenticationDto() { // JACKSON
    }

    public String getUsername() {
        return this.username;
    }

    public String getPassword() {
        return this.password;
    }

    @Override
    public User toEntity() {
        return new UserBuilder()
                .withName(this.username)
                .withPassword(this.password)
                .build();
    }
}
