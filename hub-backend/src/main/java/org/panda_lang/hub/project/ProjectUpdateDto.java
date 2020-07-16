/*
 * Copyright (c) 2018-2019 Hub Team
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

package org.panda_lang.hub.project;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.URL;
import org.panda_lang.hub.user.Owner;
import org.panda_lang.hub.utils.entity.AbstractDto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

final class ProjectUpdateDto extends AbstractDto<Project> {

    @NotNull(message = "{name.notNull}") @NotEmpty(message = "{name.notEmpty}") @Length(min = 3, max = 32, message = "{name.length}")
    private String name;
    @NotNull(message = "{owner.notNull}")
    private Owner owner;
    @URL(message = "{source.format}") @NotEmpty(message = "{source.notEmpty}") @NotNull(message = "{source.notNull}")
    private String platformUri;
    @URL(message = "{website.format}") @NotEmpty(message = "{website.notEmpty}") @NotNull(message = "{website.notNull}")
    private String website;

    public ProjectUpdateDto(String name, Owner owner, String platformUri, String website) {
        this.name = name;
        this.owner = owner;
        this.platformUri = platformUri;
        this.website = website;
    }

    public ProjectUpdateDto() {
        // Jackson
    }

    public String getWebsite() {
        return website;
    }

    public String getPlatformUri() {
        return platformUri;
    }

    public Owner getOwner() {
        return owner;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Project toEntity() {
        return new Project(name, owner, platformUri, website);
    }

}
