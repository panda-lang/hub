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
package org.panda_lang.hub.organization

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class OrganizationUpdateDtoTest {
    @get:Test
    val description: Unit
        get() {
            assertEquals("description", DTO.getDescription())
        }

    @get:Test
    val email: Unit
        get() {
            assertEquals("email", DTO.getEmail())
        }

    @get:Test
    val site: Unit
        get() {
            assertEquals("site", DTO.getSite())
        }

    @get:Test
    val displayName: Unit
        get() {
            assertEquals("display name", DTO.getDisplayName())
        }

    @get:Test
    val name: Unit
        get() {
            assertEquals("name", DTO.getName())
        }

    companion object {
        private val DTO: OrganizationUpdateDto = OrganizationUpdateDto("name", "display name", "description", "email", "site")
    }
}
