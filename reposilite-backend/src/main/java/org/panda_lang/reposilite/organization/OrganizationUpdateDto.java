package org.panda_lang.reposilite.organization;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.URL;
import org.panda_lang.reposilite.utils.AbstractDto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

public class OrganizationUpdateDto extends AbstractDto<Organization> {

    @NotEmpty @Length(min = 3)
    private String name;
    @NotEmpty @Length(min = 3)
    private String displayName;
    @NotEmpty @Length(min = 5)
    private String description;
    @NotEmpty @Email
    private String email;
    @NotEmpty @URL
    private String site;

    public OrganizationUpdateDto(String name, String displayName, String description, String email, String site) {
        this.name = name;
        this.displayName = displayName;
        this.description = description;
        this.email = email;
        this.site = site;
    }

    public OrganizationUpdateDto() { // Jackson

    }

    public String getName() {
        return this.name;
    }

    public String getDisplayName() {
        return this.displayName;
    }

    public String getDescription() {
        return this.description;
    }

    public String getEmail() {
        return this.email;
    }

    public String getSite() {
        return this.site;
    }

    @Override
    public Organization toEntity() {
        return new OrganizationBuilder()
                .withName(this.name)
                .withDescription(this.description)
                .withDisplayName(this.displayName)
                .withEmail(this.email)
                .withSite(this.site)
                .build();
    }
}
