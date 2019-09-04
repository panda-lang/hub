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

import com.mongodb.BasicDBObject;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.panda_lang.reposilite.user.User;
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

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class RoleCommandsIntegrationTest {

    @Autowired
    private Shell shell;

    @Autowired
    private MongoTemplate mongoTemplate;

    @Autowired
    private RoleFactory roleFactory;

    @Test
    void rolesCommandTest() {
        Object result = this.shell.evaluate(() -> "roles");
        assertEquals("", result);
    }

    @Test
    void setRoleCommandTest() {
        Map<String, Object> userDetails = new HashMap<String, Object>() {{
            this.put("name", "testUser2115");
            this.put("roles", Collections.emptySet());
        }};

        this.mongoTemplate.insert(new BasicDBObject(userDetails), "users");
        Object result = this.shell.evaluate(() -> "chrole testUser2115 ADMIN");
        User user = this.mongoTemplate.findOne(Query.query(Criteria.where("name").is("testUser2115")), User.class);

        assertAll(
                () -> assertNotNull(this.mongoTemplate.findById("ADMIN", Role.class)),
                () -> assertNotNull(user),
                () -> assertTrue(user.getRoles().toString().contains("ADMIN")),
                () -> assertEquals("Set role `ADMIN` for user: testUser2115", result)
        );
    }

    @Test
    void setRoleCommandWhenUserNotFound() {
        Object result = this.shell.evaluate(() -> "chrole testUser1337 ADMIN");
        assertEquals("User not found!", result);
    }

    @AfterEach
    void tearDown() {
        this.mongoTemplate.dropCollection("users");
        this.mongoTemplate.dropCollection("roles");
    }

}
