package org.panda_lang.reposilite.organization;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.URL;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

public class OrganizationCreationForm {

    @NotNull @Length(min = 3)
    private String name;
    @NotNull @Length(min = 3)
    private String displayName;
    @NotNull @Length(min = 5)
    private String description;
    @NotNull @Email
    private String email;
    @NotNull @URL
    private String site;

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDisplayName() {
        return this.displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSite() {
        return this.site;
    }

    public void setSite(String site) {
        this.site = site;
    }

}
