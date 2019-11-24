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

package org.panda_lang.reposilite.utils.entity.crud;

import org.panda_lang.reposilite.utils.entity.AbstractDto;

import javax.validation.constraints.NotEmpty;

public class TestDto extends AbstractDto<TestEntity> {

    @NotEmpty
    private String username;

    @NotEmpty
    private String something;

    public TestDto(String username, String something) {
        this.username = username;
        this.something = something;
    }

    public TestDto() {
        // Jackson
    }

    public String getUsername() {
        return this.username;
    }

    public String getSomething() {
        return this.something;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setSomething(String something) {
        this.something = something;
    }

    @Override
    public String getName() {
        return this.username;
    }

    public TestEntity toEntity() {
        return new TestEntity(null, this.username, this.something);
    }

}
