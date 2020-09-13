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
import org.panda_lang.hub.utils.entity.AbstractDto
import org.panda_lang.hub.utils.validation.FieldMatch
import javax.validation.constraints.Email
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull

@FieldMatch.AsList(
        FieldMatch(first = "password", second = "confirmPassword", message = "{match.password}"),
        FieldMatch(first = "email", second = "confirmEmail", message = "{match.email}")
)
data class UserRegistrationDto(
        @field:NotEmpty(message = "{username.notEmpty}")
        @field:NotNull(message = "{username.notNull}")
        @field:Length(min = 3, max = 32, message = "{username.length}")
        override val name: String,
        @field:NotEmpty(message = "{displayName.notEmpty}")
        @field:NotNull(message = "{displayName.notNull}")
        @field:Length(min = 3, max = 32, message = "{displayName.length}")
        val displayName: String,
        @NotEmpty(message = "{password.notEmpty}")
        @NotNull(message = "{password.notNull}")
        @Length(min = 6, message = "{password.length}")
        val password: String,
        val confirmPassword: String,
        @NotEmpty(message = "{email.notEmpty}")
        @NotNull(message = "{email.notNull}")
        @Email(message = "{email.format}")
        val email: String,
        val confirmEmail: String
) : AbstractDto<User>() {

    override fun toEntity(): User {
        return User(
                null,
                name,
                displayName,
                password,
                email,
                "",
                "",
                "",
                "",
                "",
                HashSet()
        )
    }

}