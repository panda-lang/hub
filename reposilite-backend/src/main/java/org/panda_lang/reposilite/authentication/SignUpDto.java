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

package org.panda_lang.reposilite.authentication;

import org.panda_lang.reposilite.utils.entity.JsonDto;

public class SignUpDto extends JsonDto {

    private String name;
    private String displayName;
    private String email;
    private String password;

    public SignUpDto(String name, String displayName, String email, String password) {
        this.name = name;
        this.displayName = displayName;
        this.password = password;
        this.email = email;
    }

    SignUpDto() { }

    public String getPassword() {
        return this.password;
    }

    public String getEmail() {
        return this.email;
    }

    public String getDisplayName() {
        return this.displayName;
    }

    public String getName() {
        return this.name;
    }

}
