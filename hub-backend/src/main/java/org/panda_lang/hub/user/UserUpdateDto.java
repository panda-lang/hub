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

package org.panda_lang.hub.user;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.URL;
import org.panda_lang.hub.utils.entity.AbstractDto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

final class UserUpdateDto extends AbstractDto<User> {

    @NotEmpty(message = "{username.notEmpty}") @NotNull(message = "{username.notNull}") @Length(min = 3, max = 32, message = "{username.length}")
    private String username;
    @NotEmpty(message = "{displayName.notEmpty}") @NotNull(message = "{displayName.notNull}") @Length(min = 3, max = 32, message = "{displayName.length}")
    private String displayName;
    @NotEmpty(message = "{password.notEmpty}") @NotNull(message = "{password.notNull}") @Length(min = 6, message = "{password.length}")
    private String password;
    @NotEmpty(message = "{description.notEmpty}") @NotNull(message = "{description.notNull}") @Length(max = 200, message = "{description.length}")
    private String description;
    @NotEmpty(message = "{email.notEmpty}") @NotNull(message = "{email.notNull}") @Email(message = "{email.format}")
    private String email;
    @URL(message = "{site.format}") @NotEmpty(message = "{site.notEmpty}") @NotNull(message = "{site.notNull}")
    private String site;

    public UserUpdateDto(String name, String displayName, String password, String description, String email, String site) {
        this.username = name;
        this.displayName = displayName;
        this.password = password;
        this.description = description;
        this.email = email;
        this.site = site;
    }

    public UserUpdateDto() {
        // Jackson
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
    public User toEntity() {
        return new UserBuilder()
                .withName(this.username)
                .withDisplayName(this.displayName)
                .withPassword(this.password)
                .withDescription(this.description)
                .withEmail(this.email)
                .withSite(this.site)
                .build();
    }

    @Override
    public String getName() {
        return this.username;
    }

}
