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
package org.panda_lang.hub.user

import org.hibernate.validator.constraints.Length
import org.hibernate.validator.constraints.URL
import org.panda_lang.hub.utils.entity.AbstractDto
import javax.validation.constraints.Email
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull

internal class UserUpdateDto(
        @field:NotEmpty(message = "{username.notEmpty}")
        @field:NotNull(message = "{username.notNull}")
        @field:Length(min = 3, max = 32, message = "{username.length}")
        override val name: String,
        @field:NotEmpty(message = "{displayName.notEmpty}")
        @field:NotNull(message = "{displayName.notNull}")
        @field:Length(min = 3, max = 32, message = "{displayName.length}")
        val displayName: String,
        @field:NotEmpty(message = "{password.notEmpty}")
        @field:NotNull(message = "{password.notNull}")
        @field:Length(min = 6, message = "{password.length}")
        val password: String,
        @field:NotEmpty(message = "{description.notEmpty}")
        @field:NotNull(message = "{description.notNull}")
        @field:Length(max = 200, message = "{description.length}")
        val description: String,
        @field:NotEmpty(message = "{email.notEmpty}")
        @field:NotNull(message = "{email.notNull}")
        @field:Email(message = "{email.format}")
        val email: String,
        @field:URL(message = "{site.format}")
        @field:NotEmpty(message = "{site.notEmpty}")
        @field:NotNull(message = "{site.notNull}")
        val site: String
) : AbstractDto<User>() {

    override fun toEntity(): User {
        return User(
                name,
                displayName,
                password,
                description,
                email,
                "",
                "",
                "",
                site,
                HashSet()
        )
    }

}