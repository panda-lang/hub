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
package org.panda_lang.hub.utils.entity

import com.google.common.collect.Sets
import com.mongodb.BasicDBObject
import org.bson.types.ObjectId
import org.hamcrest.Matchers
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions.assertAll
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotEquals
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Assertions.assertNull
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.runner.RunWith
import org.panda_lang.hub.user.role.RoleFactory
import org.panda_lang.hub.utils.entity.crud.TestDto
import org.panda_lang.hub.utils.entity.crud.TestEntity
import org.panda_lang.hub.utils.entity.crud.TestEntityController
import org.panda_lang.hub.utils.entity.crud.TestRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.data.mongodb.core.query.Criteria
import org.springframework.data.mongodb.core.query.Query
import org.springframework.http.MediaType
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors
import org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.test.context.web.WebAppConfiguration
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import org.springframework.test.web.servlet.setup.MockMvcBuilders
import org.springframework.web.context.WebApplicationContext
import java.util.HashMap
import java.util.Map
import kotlin.Throws

@RunWith(SpringRunner::class)
@SpringBootTest
@ContextConfiguration
@WebAppConfiguration
internal class AbstractCrudControllerIntegrationTest {
    @Autowired
    private val mongoTemplate: MongoTemplate? = null

    @Autowired
    private val testEntityController: TestEntityController? = null

    @Autowired
    private val repository: TestRepository? = null

    @Autowired
    private val passwordEncoder: PasswordEncoder? = null

    @Autowired
    private val context: WebApplicationContext? = null

    @Autowired
    private val roleFactory: RoleFactory? = null
    private var mockMvc: MockMvc? = null
    @BeforeEach
    fun setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(context)
            .apply(SecurityMockMvcConfigurers.springSecurity())
            .build()
    }

    @Test
    @Throws(Exception::class)
    fun readAllEntitiesTest() {
        repository.save(TestEntity(ObjectId.get(), "testEntity1125", "something"))
        repository.save(TestEntity(ObjectId.get(), "testEntity1126", "something"))
        mockMvc.perform(MockMvcRequestBuilders.get("/api/tests"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$[0].name", Matchers.`is`("testEntity1125")))
            .andExpect(jsonPath("$[1].name", Matchers.`is`("testEntity1126")))
    }

    @Test
    @Throws(Exception::class)
    fun readShouldReturn404WhenDoesNotExists() {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/tests/{id}", ObjectId.get()))
            .andExpect(status().isNotFound())
    }

    @Test
    @Throws(Exception::class)
    fun readTest() {
        val id: ObjectId = ObjectId.get()
        repository.save(TestEntity(id, "testEntity1127", "something"))
        mockMvc.perform(MockMvcRequestBuilders.get("/api/tests/{id}", id.toHexString()))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.name", Matchers.`is`("testEntity1127")))
            .andExpect(jsonPath("$.identifier", Matchers.`is`(id.toHexString())))
    }

    @Test
    @Throws(Exception::class)
    fun createTest() {
        val testDto = TestDto("testEntity1128", "something")
        mockMvc.perform(
            MockMvcRequestBuilders.post("/api/tests")
                .content(testDto.toJson().getBytes())
                .contentType(MediaType.APPLICATION_JSON)
        )
            .andExpect(status().isCreated())
            .andExpect(jsonPath("$.name", Matchers.`is`("testEntity1128")))
    }

    @Test
    @Throws(Exception::class)
    fun createShouldReturn409WhenAlreadyExists() {
        val testDto = TestDto("testEntity1129", "something")
        repository.save(TestEntity(ObjectId.get(), "testEntity1129", "something"))
        mockMvc.perform(
            MockMvcRequestBuilders.post("/api/tests")
                .content(testDto.toJson().getBytes())
                .contentType(MediaType.APPLICATION_JSON)
        )
            .andExpect(status().isConflict())
    }

    @Test
    @Throws(Exception::class)
    fun createShouldReturn400WhenValidationError() {
        val testDto = TestDto(null, null)
        mockMvc.perform(
            MockMvcRequestBuilders.post("/api/tests")
                .content(testDto.toJson().getBytes())
                .contentType(MediaType.APPLICATION_JSON)
        )
            .andExpect(status().isBadRequest())
    }

    @Test
    @Throws(Exception::class)
    private fun updateTest() {
        val id: ObjectId = ObjectId.get()
        val username = "testEntity123132"
        val password = "test123"
        val testDto = TestDto(username + "_EDITED", "something")
        val testEntity = TestEntity(id, username, "something")
        repository.save(testEntity)
        setUpUser(id, username, password)
        mockMvc.perform(
            MockMvcRequestBuilders.put("/api/tests/{id}", id)
                .with(SecurityMockMvcRequestPostProcessors.httpBasic(username, password))
                .content(testDto.toJson())
                .contentType(MediaType.APPLICATION_JSON)
        )
            .andExpect(status().isNoContent())
        val query: Query = Query.query(Criteria.where("name").`is`(testDto.getUsername()))
        val databaseEntity: TestEntity = mongoTemplate.findOne(query, TestEntity::class.java)
        assertAll(
            { assertNotNull(databaseEntity) },
            { assertNotEquals(databaseEntity, testEntity) }
        ) { assertEquals(username + "_EDITED", databaseEntity.getName()) }
    }

    @Test
    @Throws(Exception::class)
    fun updateShouldCreateNewEntityWhenEntityNotFound() {
        val id: ObjectId = ObjectId.get()
        val username = "testEntity3901028930"
        val password = "test123"
        val testDto = TestDto(username + "_EDITED", "something")
        val testEntity = TestEntity(id, username, "something")
        setUpUser(id, username, password)
        mockMvc.perform(
            MockMvcRequestBuilders.put("/api/tests/{id}", id)
                .with(SecurityMockMvcRequestPostProcessors.httpBasic(username, password))
                .content(testDto.toJson())
                .contentType(MediaType.APPLICATION_JSON)
        )
            .andExpect(status().isCreated())
        val query: Query = Query.query(Criteria.where("name").`is`(testDto.getUsername()))
        val databaseEntity: TestEntity = mongoTemplate.findOne(query, TestEntity::class.java)
        assertAll(
            { assertNotNull(databaseEntity) },
            { assertNotEquals(databaseEntity, testEntity) }
        ) { assertEquals(testDto.getUsername(), databaseEntity.getName()) }
    }

    @Test
    @Throws(Exception::class)
    fun updateShouldReturn403WhenDifferentUser() {
        val id: ObjectId = ObjectId.get()
        val username = "testEntity30182u8038"
        val password = "test123"
        val testDto = TestDto(username + "_EDITED", "something")
        val testEntity = TestEntity(id, username, "something")
        repository.save(testEntity)
        setUpUser(ObjectId.get(), username, password)
        mockMvc.perform(
            MockMvcRequestBuilders.put("/api/tests/{id}", id)
                .with(SecurityMockMvcRequestPostProcessors.httpBasic(username, password))
                .content(testDto.toJson().getBytes())
                .contentType(MediaType.APPLICATION_JSON)
        )
            .andExpect(status().isForbidden())
    }

    @Test
    @Throws(Exception::class)
    fun updateShouldReturn400WhenValidationError() {
        val id: ObjectId = ObjectId.get()
        val username = "testEntity30182u8038"
        val password = "test123"
        val testDto = TestDto("", "")
        val testEntity = TestEntity(id, username, "something")
        repository.save(testEntity)
        setUpUser(id, username, password)
        mockMvc.perform(
            MockMvcRequestBuilders.put("/api/tests/{id}", id)
                .with(SecurityMockMvcRequestPostProcessors.httpBasic(username, password))
                .content(testDto.toJson().getBytes())
                .contentType(MediaType.APPLICATION_JSON)
        )
            .andExpect(status().isBadRequest())
    }

    @Test
    @Throws(Exception::class)
    fun partialUpdateTest() {
        val id: ObjectId = ObjectId.get()
        val username = "testEntity123131"
        val password = "test123"
        val dto = TestDto(null, "something_EDITED")
        val testEntity = TestEntity(id, username, "something")
        repository.save(testEntity)
        setUpUser(id, username, password)
        mockMvc.perform(
            MockMvcRequestBuilders.patch("/api/tests/{id}", id)
                .with(SecurityMockMvcRequestPostProcessors.httpBasic(username, password))
                .content(dto.toJson().getBytes())
                .contentType(MediaType.APPLICATION_JSON)
        )
            .andExpect(status().isNoContent())
        val query: Query = Query.query(Criteria.where("name").`is`(username))
        val databaseEntity: TestEntity = mongoTemplate.findOne(query, TestEntity::class.java)
        assertNotNull(databaseEntity)
        assertAll(
            { assertNotNull(databaseEntity.getSomething()) },
            { assertEquals(databaseEntity.getSomething(), "something_EDITED") }
        ) { assertEquals(databaseEntity.getName(), username) }
    }

    @Test
    @Throws(Exception::class)
    fun partialUpdateShouldReturn404WhenEntityNotFound() {
        val id: ObjectId = ObjectId.get()
        val username = "testEntity3901903190"
        val password = "test123"
        val dto = TestDto(null, "something_EDITED")
        val testEntity = TestEntity(id, username, "something")
        setUpUser(id, username, password)
        mockMvc.perform(
            MockMvcRequestBuilders.patch("/api/tests/{id}", id)
                .with(SecurityMockMvcRequestPostProcessors.httpBasic(username, password))
                .content(dto.toJson().getBytes())
                .contentType(MediaType.APPLICATION_JSON)
        )
            .andExpect(status().isNotFound())
    }

    @Test
    @Throws(Exception::class)
    fun partialUpdateShouldReturn403WhenDifferentUser() {
        val id: ObjectId = ObjectId.get()
        val username = "testEntity3901903190"
        val password = "test123"
        val dto = TestDto(null, "something_EDITED")
        setUpUser(ObjectId.get(), username, password)
        mockMvc.perform(
            MockMvcRequestBuilders.patch("/api/tests/{id}", id)
                .with(SecurityMockMvcRequestPostProcessors.httpBasic(username, password))
                .content(dto.toJson().getBytes())
                .contentType(MediaType.APPLICATION_JSON)
        )
            .andExpect(status().isForbidden())
    }

    @Test
    @Throws(Exception::class)
    fun deleteTest() {
        val id: ObjectId = ObjectId.get()
        val username = "testEntity12313"
        val password = "test123"
        mongoTemplate.insert(TestEntity(id, username, "something"))
        val query: Query = Query.query(Criteria.where("name").`is`(username))
        assertNotNull(mongoTemplate.findOne(query, TestEntity::class.java))
        setUpUser(id, username, password)
        mockMvc.perform(
            MockMvcRequestBuilders.delete("/api/tests/{id}", id)
                .with(SecurityMockMvcRequestPostProcessors.httpBasic(username, password))
        )
            .andExpect(status().isNoContent())
        assertNull(mongoTemplate.findOne(query, TestEntity::class.java))
    }

    @Test
    @Throws(Exception::class)
    fun deleteShouldReturn404WhenEntityNotFound() {
        val id: ObjectId = ObjectId.get()
        val username = "testEntity123812"
        val password = "test123"
        setUpUser(id, username, password)
        mockMvc.perform(
            MockMvcRequestBuilders.delete("/api/tests/{id}", id)
                .with(SecurityMockMvcRequestPostProcessors.httpBasic(username, password))
        )
            .andExpect(status().isNotFound())
    }

    private fun setUpUser(id: ObjectId, username: String, password: String) {
        val userDetails: Map<String, Object> = object : HashMap<String?, Object?>() {
            init {
                this.put("_id", id)
                this.put("name", username)
                this.put("password", passwordEncoder.encode(password))
                this.put("roles", Sets.newHashSet(roleFactory.obtainRole("USER")))
            }
        }
        mongoTemplate.insert(BasicDBObject(userDetails), "users")
    }

    @AfterEach
    fun tearDown() {
        mongoTemplate.dropCollection("tests")
        mongoTemplate.dropCollection("users")
    }
}
