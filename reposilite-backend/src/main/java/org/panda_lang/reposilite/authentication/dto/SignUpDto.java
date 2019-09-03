package org.panda_lang.reposilite.authentication.dto;

public class SignUpDto {

    private String name;
    private String password;
    private String email;
    private String displayName;

    public String getName() {
        return this.name;
    }

    public String getPassword() {
        return this.password;
    }

    public String getEmail() {
        return this.email;
    }

    public String getDisplayName() {
        return this.displayName;
    }

}
