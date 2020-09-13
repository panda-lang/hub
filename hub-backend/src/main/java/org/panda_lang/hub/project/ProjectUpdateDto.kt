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
package org.panda_lang.hub.project

import org.hibernate.validator.constraints.Length
import org.hibernate.validator.constraints.URL
import org.panda_lang.hub.user.Owner
import org.panda_lang.hub.utils.entity.AbstractDto
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull

internal class ProjectUpdateDto(
        @field:NotNull(message = "{name.notNull}")
        @field:NotEmpty(message = "{name.notEmpty}")
        @field:Length(min = 3, max = 32, message = "{name.length}")
        override val name: String,
        @field:NotNull(message = "{owner.notNull}")
        val owner: Owner,
        @field:URL(message = "{source.format}")
        @field:NotEmpty(message = "{source.notEmpty}")
        @field:NotNull(message = "{source.notNull}")
        val platformUri: String,
        @field:URL(message = "{website.format}")
        @field:NotEmpty(message = "{website.notEmpty}")
        @field:NotNull(message = "{website.notNull}")
        val website: String
) : AbstractDto<Project>() {

    override fun toEntity(): Project {
        return Project(null, name, owner, platformUri, website)
    }

}