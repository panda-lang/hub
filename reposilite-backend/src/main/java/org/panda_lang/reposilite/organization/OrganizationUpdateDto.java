package org.panda_lang.reposilite.organization;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.URL;
import org.panda_lang.reposilite.utils.AbstractDto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class OrganizationUpdateDto extends AbstractDto<Organization> {

    @NotNull(message = "{name.notNull}") @NotEmpty(message = "{name.notEmpty}") @Length(min = 3, max = 32, message = "{name.length}")
    private String name;
    @NotNull(message = "{displayName.notNull}") @NotEmpty(message = "{displayName.notEmpty}") @Length(min = 3, max = 32, message = "{displayName.length}")
    private String displayName;
    @NotEmpty(message = "{description.notEmpty}") @NotNull(message = "{description.notNull}") @Length(max = 200, message = "{description.length}")
    private String description;
    @NotEmpty(message = "{email.notEmpty}") @NotNull(message = "{email.notNull}") @Email(message = "{email.format}")
    private String email;
    @URL(message = "{site.format}") @NotEmpty(message = "{site.notEmpty}") @NotNull(message = "{site.notNull}")
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
