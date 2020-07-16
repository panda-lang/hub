/*
 * Copyright (c) 2020 Hub Team of panda-lang organization
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.panda_lang.hub.organization;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.URL;
import org.panda_lang.hub.utils.entity.AbstractDto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

final class OrganizationUpdateDto extends AbstractDto<Organization> {

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

    public OrganizationUpdateDto() {
        // Jackson
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

    public String getDisplayName() {
        return this.displayName;
    }

    @Override
    public String getName() {
        return this.name;
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
