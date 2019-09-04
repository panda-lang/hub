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

package org.panda_lang.reposilite.user.role;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class RoleFactoryIntegrationTest {

    @Autowired
    private RoleFactory roleFactory;

    @Autowired
    private MongoTemplate mongoTemplate;

    @Test
    void obtainNewRoleTest() {
        Role role = this.roleFactory.obtainRole("SUPER_VIP");

        assertAll(
                () -> assertNotNull(role),
                () -> assertNotNull(this.mongoTemplate.findById("SUPER_VIP", Role.class))
        );
    }

    @AfterEach
    void tearDown() {
        this.mongoTemplate.dropCollection("roles");
    }

}
