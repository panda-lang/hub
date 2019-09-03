package org.panda_lang.reposilite.user;

import org.hibernate.validator.constraints.Length;
import org.panda_lang.reposilite.utils.entity.AbstractDto;
import org.panda_lang.reposilite.utils.validation.FieldMatch;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@FieldMatch.AsList({
        @FieldMatch(first = "password", second = "confirmPassword", message = "{match.password}"),
        @FieldMatch(first = "email", second = "confirmEmail", message = "{match.email}")
})
public final class UserRegistrationDto extends AbstractDto<User> {

    @NotEmpty(message = "{username.notEmpty}") @NotNull(message = "{username.notNull}") @Length(min = 3, max = 32, message = "{username.length}")
    private String username;
    @NotEmpty(message = "{displayName.notEmpty}") @NotNull(message = "{displayName.notNull}") @Length(min = 3, max = 32, message = "{displayName.length}")
    private String displayName;
    @NotEmpty(message = "{password.notEmpty}") @NotNull(message = "{password.notNull}") @Length(min = 6, message = "{password.length}")
    private String password;
    private String confirmPassword;
    @NotEmpty(message = "{email.notEmpty}") @NotNull(message = "{email.notNull}") @Email(message = "{email.format}")
    private String email;
    private String confirmEmail;

    public UserRegistrationDto(String username, String displayName, String password, String confirmPassword, String email, String confirmEmail) {
        this.username = username;
        this.displayName = displayName;
        this.password = password;
        this.confirmPassword = confirmPassword;
        this.email = email;
        this.confirmEmail = confirmEmail;
    }

    public UserRegistrationDto() { // JACKSON

    }

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
