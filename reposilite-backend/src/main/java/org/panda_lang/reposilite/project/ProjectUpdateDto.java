/*
 * Copyright (c) 2018-2019 Reposilite Team
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

package org.panda_lang.reposilite.project;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.URL;
import org.panda_lang.reposilite.user.ProjectOwner;
import org.panda_lang.reposilite.utils.entity.AbstractDto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

final class ProjectUpdateDto extends AbstractDto<Project> {

    @NotNull(message = "{name.notNull}") @NotEmpty(message = "{name.notEmpty}") @Length(min = 3, max = 32, message = "{name.length}")
    private String name;
    @NotNull(message = "{owner.notNull}")
    private ProjectOwner owner;
    @URL(message = "{address.format}") @NotEmpty(message = "{address.notEmpty}") @NotNull(message = "{address.notNull}")
    private String address;

    public ProjectUpdateDto(String name, ProjectOwner owner,String address) {
        this.name = name;
        this.owner = owner;
        this.address = address;
    }

    public ProjectUpdateDto() {
        // Jackson
    }

    public ProjectOwner getOwner() {
        return owner;
    }

    public String getAddress() {
        return address;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Project toEntity() {
        return new Project(name, owner, address);
    }

}
