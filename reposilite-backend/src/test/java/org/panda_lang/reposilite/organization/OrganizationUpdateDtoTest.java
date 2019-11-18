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

package org.panda_lang.reposilite.organization;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrganizationUpdateDtoTest {

    private static final OrganizationUpdateDto DTO = new OrganizationUpdateDto("name", "display name", "description", "email", "site");

    @Test
    void getDescription() {
        assertEquals("description", DTO.getDescription());
    }

    @Test
    void getEmail() {
        assertEquals("email", DTO.getEmail());
    }

    @Test
    void getSite() {
        assertEquals("site", DTO.getSite());
    }

    @Test
    void getDisplayName() {
        assertEquals("display name", DTO.getDisplayName());
    }

    @Test
    void getName() {
        assertEquals("name", DTO.getName());
    }

}