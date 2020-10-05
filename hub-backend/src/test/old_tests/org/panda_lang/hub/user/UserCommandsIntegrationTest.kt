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
package org.panda_lang.hub.user

import com.mongodb.BasicDBObject
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions.assertAll
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.data.mongodb.core.query.Criteria
import org.springframework.data.mongodb.core.query.Query
import org.springframework.shell.Shell
import org.springframework.test.context.junit4.SpringRunner
import java.util.HashMap
import java.util.Map

@RunWith(SpringRunner::class)
@SpringBootTest
internal class UserCommandsIntegrationTest {
    @Autowired
    private val shell: Shell? = null

    @Autowired
    private val mongoTemplate: MongoTemplate? = null
    @Test
    fun userAddCommandTest() {
        val result: Object = shell.evaluate { "useradd testUser123" }
        val query = Query()
        query.addCriteria(Criteria.where("name").`is`("testUser123"))
        assertAll(
            { assertTrue(mongoTemplate.exists(query, "users")) }
        ) { assertEquals("Created user: testUser123", result) }
    }

    @Test
    fun userAddAlreadyExistsTest() {
        val userDetails: Map<String, Object> = object : HashMap<String?, Object?>() {
            init {
                this.put("name", "testUser")
            }
        }
        mongoTemplate.insert(BasicDBObject(userDetails), "users")
        val result: Object = shell.evaluate { "useradd testUser" }
        assertEquals("User already exists", result)
    }

    @Test
    fun passwdCommandTest() {
        val userDetails: Map<String, Object> = object : HashMap<String?, Object?>() {
            init {
                this.put("name", "testUser133")
            }
        }
        val userDbObject = BasicDBObject(userDetails)
        mongoTemplate.insert(userDbObject, "users")
        val result: Object = shell.evaluate { "passwd testUser133 test" }
        val user: User = mongoTemplate.findOne(Query().addCriteria(Criteria.where("name").`is`("testUser133")), User::class.java, "users")
        assertAll(
            { assertEquals("Set password for user: testUser133", result) }
        ) { assertNotNull(user.getPassword()) }
    }

    @Test
    fun passwdUserNotFoundTest() {
        val result: Object = shell.evaluate { "passwd testUser135 test" }
        assertEquals("User not found!", result)
    }

    @AfterEach
    fun tearDown() {
        mongoTemplate.dropCollection("users")
    }
}
