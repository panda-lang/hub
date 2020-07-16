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

package org.panda_lang.hub.utils;

import org.bson.types.ObjectId;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.panda_lang.hub.utils.entity.crud.TestEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@RunWith(SpringRunner.class)
class BeanUtilTest {

    @Test
    void copyNonNullProperties() {
        ObjectId id = ObjectId.get();

        TestEntity testEntity = new TestEntity(id, "testUsername", "something fucked up");
        TestEntity testEntityEdited = new TestEntity(null, "testUsernameButEdited", null);

        BeanUtil.copyNonNullProperties(testEntity, testEntityEdited);

        assertAll(
                () -> assertNotNull(testEntity),
                () -> assertNotNull(testEntityEdited),
                () -> assertEquals(testEntityEdited.getName(), testEntity.getName()),
                () -> assertEquals(testEntityEdited.getIdentifier(), testEntity.getIdentifier()),
                () -> assertEquals(testEntityEdited.getSomething(), testEntity.getSomething())
        );
    }

}