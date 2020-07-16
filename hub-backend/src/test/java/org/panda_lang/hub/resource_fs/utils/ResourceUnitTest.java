/*
 * Copyright (c) 2018-2019 Hub Team
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

package org.panda_lang.hub.resource_fs.utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ResourceUnitTest {

    private static final ResourceUnit ELEMENT = ResourceUnit.of("{*group}", 1);

    @Test
    void isMultipart() {
        assertTrue(ELEMENT.isMultipart());
    }

    @Test
    void isWildcard() {
        assertTrue(ELEMENT.isWildcard());
    }

    @Test
    void getRequired() {
        assertEquals(1, ELEMENT.getRequired());
    }

    @Test
    void getName() {
        assertEquals("{group}", ELEMENT.getName());
    }

}