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
package org.panda_lang.hub.utils.entity.crud

import org.panda_lang.hub.utils.entity.AbstractDto
import javax.validation.constraints.NotEmpty

class TestDto : AbstractDto<TestEntity?> {
    @NotEmpty
    var name: String? = null
        @Override get() = field
        set

    @NotEmpty
    var something: String? = null

    constructor(username: String?, something: String?) {
        name = username
        this.something = something
    }

    constructor() {
        // Jackson
    }

    fun toEntity(): TestEntity {
        return TestEntity(null, name, something)
    }
}
