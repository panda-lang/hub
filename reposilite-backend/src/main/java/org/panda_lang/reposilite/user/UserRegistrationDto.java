package org.panda_lang.reposilite.user;

import org.hibernate.validator.constraints.Length;
import org.panda_lang.reposilite.auth.FieldMatch;
import org.panda_lang.reposilite.utils.AbstractDto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@FieldMatch.AsList({
        @FieldMatch(first = "password", second = "confirmPassword", message = "The confirmation password must match password"),
        @FieldMatch(first = "email", second = "confirmEmail", message = "The confirmation email must match email address")
})
public class UserRegistrationDto extends AbstractDto<User> {

    @NotNull @Length(min = 3)
    private String username;
    @NotNull @Length(min = 3)
    private String displayName;
    @NotNull @Length(min = 6)
    private String password;
    private String confirmPassword;
    @Email
    private String email;
    @Email
    private String confirmEmail;

    public String getUsername() {
        return this.username;
    }

    public String getDisplayName() {
        return this.displayName;
    }

    public String getPassword() {
        return this.password;
    }

    public String getConfirmPassword() {
        return this.confirmPassword;
    }

    public String getEmail() {
        return this.email;
    }

    public String getConfirmEmail() {
        return this.confirmEmail;
    }

    @Override
    public User toEntity() {
        return new UserBuilder()
                .withName(this.username)
                .withDisplayName(this.displayName)
                .withPassword(this.password)
                .withEmail(this.email)
                .build();
    }

}
