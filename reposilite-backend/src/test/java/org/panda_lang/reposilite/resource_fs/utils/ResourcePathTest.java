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

package org.panda_lang.reposilite.resource_fs.utils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class ResourcePathTest {

    private static ResourcePath path;

    @BeforeAll
    static void prepare() {
        path = ResourcePath.parse("{repository}/{*group}/{artifact}");
    }

    @Test
    void forElement() {
        Assertions.assertEquals("{repository}", path.forElement(3, 0).getName());
        Assertions.assertEquals("{group}", path.forElement(3, 1).getName());
        Assertions.assertEquals("{artifact}", path.forElement(3, 2).getName());

        Assertions.assertEquals("{group}", path.forElement(5, 3).getName());
        Assertions.assertEquals("{artifact}", path.forElement(5, 4).getName());
    }

    @Test
    void parse() {
        Assertions.assertNotNull(path);
        Assertions.assertEquals(3, path.getElements().size());
        Assertions.assertAll(
                () -> Assertions.assertEquals("{repository}", path.getElements().get(0).getName()),
                () -> Assertions.assertEquals("{group}", path.getElements().get(1).getName()),
                () -> Assertions.assertEquals("{artifact}", path.getElements().get(2).getName())
        );
    }

}