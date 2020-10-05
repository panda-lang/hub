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
package org.panda_lang.hub.user.role

import com.mongodb.BasicDBObject
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions.assertAll
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.runner.RunWith
import org.panda_lang.hub.user.User
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.data.mongodb.core.query.Criteria
import org.springframework.data.mongodb.core.query.Query
import org.springframework.shell.Shell
import org.springframework.test.context.junit4.SpringRunner
import java.util.Collections
import java.util.HashMap
import java.util.Map

@RunWith(SpringRunner::class)
@SpringBootTest
internal class RoleCommandsIntegrationTest {
    @Autowired
    private val shell: Shell? = null

    @Autowired
    private val mongoTemplate: MongoTemplate? = null

    @Autowired
    private val roleFactory: RoleFactory? = null
    @BeforeEach
    fun prepareRoles() {
        roleFactory.obtainRole("ADMIN")
    }

    @Test
    fun rolesCommandTest() {
        val result: Object = shell.evaluate { "roles" }
        assertEquals("ADMIN", result)
    }

    @Test
    fun setRoleCommandTest() {
        val userDetails: Map<String, Object> = object : HashMap<String?, Object?>() {
            init {
                this.put("name", "testUser2115")
                this.put("roles", Collections.emptySet())
            }
        }
        mongoTemplate.insert(BasicDBObject(userDetails), "users")
        val result: Object = shell.evaluate { "chrole --username testUser2115 --role ADMIN" }
        val user: User = mongoTemplate.findOne(Query.query(Criteria.where("name").`is`("testUser2115")), User::class.java)
        assertNotNull(user)
        assertAll(
            { assertNotNull(mongoTemplate.findById("ADMIN", Role::class.java)) },
            { assertEquals("Set role `ADMIN` for user: testUser2115", result) }
        ) { assertTrue(user.getRoles().toString().contains("ADMIN")) }
    }

    @Test
    fun setRoleCommandWhenUserNotFound() {
        val result: Object = shell.evaluate { "chrole --username testUser1337 --role ADMIN" }
        assertEquals("User not found", result)
    }

    @AfterEach
    fun tearDown() {
        mongoTemplate.dropCollection("users")
        mongoTemplate.dropCollection("roles")
    }
}
