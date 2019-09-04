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

package org.panda_lang.reposilite.user;

import org.panda_lang.reposilite.utils.entity.AbstractDto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

final class UserAuthenticationDto extends AbstractDto<User> {

    @NotNull @NotEmpty
    private String username;

    @NotNull @NotEmpty
    private String password;

    public UserAuthenticationDto(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public UserAuthenticationDto() { // JACKSON
    }

    public String getUsername() {
        return this.username;
    }

    public String getPassword() {
        return this.password;
    }

    @Override
    public User toEntity() {
        return new UserBuilder()
                .withName(this.username)
                .withPassword(this.password)
                .build();
    }
}
