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

package org.panda_lang.hub.resource_fs;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.Collections;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class AbstractResourceTest {

    private static class TestResource extends AbstractResource {

        protected TestResource(File root, String name) {
            super(root, name);
        }

    }

    private static final TestResource ENTITY = new TestResource(new File("root"), "name");

    @BeforeAll
    static void prepare() {
        TestResource child = new TestResource(ENTITY.getFile(), "child");
        child.addEntity(new TestResource(child.getFile(), "grandchild"));
        ENTITY.addEntity(child);
    }


    @Test
    void getFile() {
        assertEquals("root", ENTITY.getFile().getParent());
    }

    @Test
    void getName() {
        assertEquals("name", ENTITY.getName());
    }

    @Test
    void createIfAbsent() {
        assertEquals("child", ENTITY.createIfAbsent("child", name -> {
            throw new RuntimeException("Should not happen");
        }).getName());
    }

    @Test
    void find() {
        Optional<Resource> grandchild = ENTITY.find("child/grandchild");
        assertTrue(grandchild.isPresent());
        assertEquals("grandchild", grandchild.get().getName());
    }

    @Test
    void getChild() {
        assertTrue(ENTITY.getChild("child").isPresent());
    }

    @Test
    void toNode() {
        assertNotNull(ENTITY.toNode());
    }

    @Test
    void getChildrenNames() {
        assertEquals(Collections.singletonList("child"), ENTITY.getChildrenNames());
    }

    @Test
    void getChildren() {
        assertEquals(1, ENTITY.getChildren().size());
    }

    @Test
    void testToString() {
        assertEquals("name", ENTITY.toString());
    }

}