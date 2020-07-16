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

package org.panda_lang.hub.user.role;

import com.mongodb.BasicDBObject;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.panda_lang.hub.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.shell.Shell;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
class RoleCommandsIntegrationTest {

    @Autowired
    private Shell shell;
    @Autowired
    private MongoTemplate mongoTemplate;
    @Autowired
    private RoleFactory roleFactory;

    @BeforeEach
    void prepareRoles() {
        roleFactory.obtainRole("ADMIN");
    }

    @Test
    void rolesCommandTest() {
        Object result = this.shell.evaluate(() -> "roles");
        assertEquals("ADMIN", result);
    }

    @Test
    void setRoleCommandTest() {
        Map<String, Object> userDetails = new HashMap<String, Object>() {{
            this.put("name", "testUser2115");
            this.put("roles", Collections.emptySet());
        }};

        this.mongoTemplate.insert(new BasicDBObject(userDetails), "users");
        Object result = this.shell.evaluate(() -> "chrole --username testUser2115 --role ADMIN");

        User user = this.mongoTemplate.findOne(Query.query(Criteria.where("name").is("testUser2115")), User.class);
        assertNotNull(user);

        assertAll(
                () -> assertNotNull(this.mongoTemplate.findById("ADMIN", Role.class)),
                () -> assertEquals("Set role `ADMIN` for user: testUser2115", result),
                () -> assertTrue(user.getRoles().toString().contains("ADMIN"))
        );
    }

    @Test
    void setRoleCommandWhenUserNotFound() {
        Object result = this.shell.evaluate(() -> "chrole --username testUser1337 --role ADMIN");
        assertEquals("User not found", result);
    }

    @AfterEach
    void tearDown() {
        this.mongoTemplate.dropCollection("users");
        this.mongoTemplate.dropCollection("roles");
    }

}
