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

package org.panda_lang.reposilite.utils.entity;

import com.google.common.collect.Sets;
import com.mongodb.BasicDBObject;
import org.bson.types.ObjectId;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.panda_lang.reposilite.user.role.RoleFactory;
import org.panda_lang.reposilite.utils.entity.crud.TestDto;
import org.panda_lang.reposilite.utils.entity.crud.TestEntity;
import org.panda_lang.reposilite.utils.entity.crud.TestEntityController;
import org.panda_lang.reposilite.utils.entity.crud.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.http.MediaType;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors;
import org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration
@WebAppConfiguration
class AbstractCrudControllerIntegrationTest {

  @Autowired
  private MongoTemplate mongoTemplate;

  @Autowired
  private TestEntityController testEntityController;

  @Autowired
  private TestRepository repository;

  @Autowired
  private PasswordEncoder passwordEncoder;

  @Autowired
  private WebApplicationContext context;

  @Autowired
  private RoleFactory roleFactory;

  private MockMvc mockMvc;

  @BeforeEach
  void setUp() {
    this.mockMvc = MockMvcBuilders.webAppContextSetup(this.context)
        .apply(SecurityMockMvcConfigurers.springSecurity())
        .build();
  }

  @Test
  void readAllEntitiesTest() throws Exception {
    this.repository.save(new TestEntity(ObjectId.get(), "testEntity1125", "something"));
    this.repository.save(new TestEntity(ObjectId.get(), "testEntity1126", "something"));

    this.mockMvc.perform(MockMvcRequestBuilders.get("/api/tests"))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$[0].username", Matchers.is("testEntity1125")))
        .andExpect(jsonPath("$[1].username", Matchers.is("testEntity1126")));
  }

  @Test
  void readShouldReturn404WhenDoesNotExists() throws Exception {
    this.mockMvc.perform(MockMvcRequestBuilders.get("/api/tests/{id}", ObjectId.get()))
        .andExpect(status().isNotFound());
  }

  @Test
  void readTest() throws Exception {
    ObjectId id = ObjectId.get();
    this.repository.save(new TestEntity(id, "testEntity1127", "something"));
    this.mockMvc.perform(MockMvcRequestBuilders.get("/api/tests/{id}", id.toHexString()))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.username", Matchers.is("testEntity1127")))
        .andExpect(jsonPath("$.identifier", Matchers.is(id.toHexString())));
  }

  @Test
  void createTest() throws Exception {
    TestDto testDto = new TestDto("testEntity1128", "something");
    this.mockMvc.perform(MockMvcRequestBuilders.post("/api/tests")
        .content(testDto.toJson().getBytes())
        .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isCreated())
        .andExpect(jsonPath("$.username", Matchers.is("testEntity1128")));
  }

  @Test
  void createShouldReturn409WhenAlreadyExists() throws Exception {
    TestDto testDto = new TestDto("testEntity1129", "something");
    this.repository.save(new TestEntity(ObjectId.get(), "testEntity1129", "something"));

    this.mockMvc.perform(MockMvcRequestBuilders.post("/api/tests")
        .content(testDto.toJson().getBytes())
        .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isConflict());
  }

  @Test
  void createShouldReturn400WhenValidationError() throws Exception {
    TestDto testDto = new TestDto(null, null);

    this.mockMvc.perform(MockMvcRequestBuilders.post("/api/tests")
        .content(testDto.toJson().getBytes())
        .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isBadRequest());
  }

  @Test
  private void updateTest() throws Exception {
    ObjectId id = ObjectId.get();
    String username = "testEntity123132";
    String password = "test123";

    TestDto testDto = new TestDto(username + "_EDITED", "something");
    TestEntity testEntity = new TestEntity(id, username, "something");
    this.repository.save(testEntity);

    this.setUpUser(id, username, password);
    this.mockMvc.perform(MockMvcRequestBuilders.put("/api/tests/{id}", id)
        .with(SecurityMockMvcRequestPostProcessors.httpBasic(username, password))
        .content(testDto.toJson())
        .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isNoContent());

    Query query = Query.query(Criteria.where("username").is(testDto.getUsername()));
    TestEntity databaseEntity = this.mongoTemplate.findOne(query, TestEntity.class);

    assertAll(
        () -> assertNotNull(databaseEntity),
        () -> assertNotEquals(databaseEntity, testEntity),
        () -> assertEquals(username + "_EDITED", databaseEntity.getUsername())
    );
  }

  @Test
  void updateShouldCreateNewEntityWhenEntityNotFound() throws Exception {
    ObjectId id = ObjectId.get();
    String username = "testEntity3901028930";
    String password = "test123";

    TestDto testDto = new TestDto(username + "_EDITED", "something");
    TestEntity testEntity = new TestEntity(id, username, "something");

    this.setUpUser(id, username, password);
    this.mockMvc.perform(MockMvcRequestBuilders.put("/api/tests/{id}", id)
        .with(SecurityMockMvcRequestPostProcessors.httpBasic(username, password))
        .content(testDto.toJson())
        .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isCreated());

    Query query = Query.query(Criteria.where("username").is(testDto.getUsername()));
    TestEntity databaseEntity = this.mongoTemplate.findOne(query, TestEntity.class);

    assertAll(
        () -> assertNotNull(databaseEntity),
        () -> assertNotEquals(databaseEntity, testEntity),
        () -> assertEquals(testDto.getUsername(), databaseEntity.getUsername())
    );
  }

  @Test
  void updateShouldReturn403WhenDifferentUser() throws Exception {
    ObjectId id = ObjectId.get();
    String username = "testEntity30182u8038";
    String password = "test123";

    TestDto testDto = new TestDto(username + "_EDITED", "something");
    TestEntity testEntity = new TestEntity(id, username, "something");
    this.repository.save(testEntity);

    this.setUpUser(ObjectId.get(), username, password);
    this.mockMvc.perform(MockMvcRequestBuilders.put("/api/tests/{id}", id)
        .with(SecurityMockMvcRequestPostProcessors.httpBasic(username, password))
        .content(testDto.toJson().getBytes())
        .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isForbidden());
  }

  @Test
  void updateShouldReturn400WhenValidationError() throws Exception {
    ObjectId id = ObjectId.get();
    String username = "testEntity30182u8038";
    String password = "test123";

    TestDto testDto = new TestDto("", "");
    TestEntity testEntity = new TestEntity(id, username, "something");
    this.repository.save(testEntity);

    this.setUpUser(id, username, password);
    this.mockMvc.perform(MockMvcRequestBuilders.put("/api/tests/{id}", id)
        .with(SecurityMockMvcRequestPostProcessors.httpBasic(username, password))
        .content(testDto.toJson().getBytes())
        .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isBadRequest());
  }

  @Test
  void partialUpdateTest() throws Exception {
    ObjectId id = ObjectId.get();
    String username = "testEntity123131";
    String password = "test123";

    TestDto dto = new TestDto(null, "something_EDITED");
    TestEntity testEntity = new TestEntity(id, username, "something");
    this.repository.save(testEntity);

    this.setUpUser(id, username, password);
    this.mockMvc.perform(MockMvcRequestBuilders.patch("/api/tests/{id}", id)
        .with(SecurityMockMvcRequestPostProcessors.httpBasic(username, password))
        .content(dto.toJson().getBytes())
        .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isNoContent());

    Query query = Query.query(Criteria.where("username").is(username));
    TestEntity databaseEntity = this.mongoTemplate.findOne(query, TestEntity.class);
    assertNotNull(databaseEntity);

    assertAll(
        () -> assertNotNull(databaseEntity.getSomething()),
        () -> assertEquals(databaseEntity.getSomething(), "something_EDITED"),
        () -> assertEquals(databaseEntity.getUsername(), username)
    );
  }

  @Test
  void partialUpdateShouldReturn404WhenEntityNotFound() throws Exception {
    ObjectId id = ObjectId.get();
    String username = "testEntity3901903190";
    String password = "test123";

    TestDto dto = new TestDto(null, "something_EDITED");
    TestEntity testEntity = new TestEntity(id, username, "something");

    this.setUpUser(id, username, password);
    this.mockMvc.perform(MockMvcRequestBuilders.patch("/api/tests/{id}", id)
        .with(SecurityMockMvcRequestPostProcessors.httpBasic(username, password))
        .content(dto.toJson().getBytes())
        .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isNotFound());
  }

  @Test
  void partialUpdateShouldReturn403WhenDifferentUser() throws Exception {
    ObjectId id = ObjectId.get();
    String username = "testEntity3901903190";
    String password = "test123";

    TestDto dto = new TestDto(null, "something_EDITED");

    this.setUpUser(ObjectId.get(), username, password);
    this.mockMvc.perform(MockMvcRequestBuilders.patch("/api/tests/{id}", id)
        .with(SecurityMockMvcRequestPostProcessors.httpBasic(username, password))
        .content(dto.toJson().getBytes())
        .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isForbidden());
  }

  @Test
  void deleteTest() throws Exception {
    ObjectId id = ObjectId.get();
    String username = "testEntity12313";
    String password = "test123";

    this.mongoTemplate.insert(new TestEntity(id, username, "something"));

    Query query = Query.query(Criteria.where("username").is(username));
    assertNotNull(this.mongoTemplate.findOne(query, TestEntity.class));

    this.setUpUser(id, username, password);
    this.mockMvc.perform(MockMvcRequestBuilders.delete("/api/tests/{id}", id)
        .with(SecurityMockMvcRequestPostProcessors.httpBasic(username, password)))
        .andExpect(status().isNoContent());

    assertNull(this.mongoTemplate.findOne(query, TestEntity.class));
  }

  @Test
  void deleteShouldReturn404WhenEntityNotFound() throws Exception {
    ObjectId id = ObjectId.get();
    String username = "testEntity123812";
    String password = "test123";

    this.setUpUser(id, username, password);
    this.mockMvc.perform(MockMvcRequestBuilders.delete("/api/tests/{id}", id)
        .with(SecurityMockMvcRequestPostProcessors.httpBasic(username, password)))
        .andExpect(status().isNotFound());
  }

  private void setUpUser(ObjectId id, String username, String password) {
    Map<String, Object> userDetails = new HashMap<String, Object>() {{
      this.put("_id", id);
      this.put("name", username);
      this.put("password", AbstractCrudControllerIntegrationTest.this.passwordEncoder.encode(password));
      this.put("roles", Sets.newHashSet(AbstractCrudControllerIntegrationTest.this.roleFactory.obtainRole("USER")));
    }};

    this.mongoTemplate.insert(new BasicDBObject(userDetails), "users");
  }

  @AfterEach
  void tearDown() {
    this.mongoTemplate.dropCollection("tests");
    this.mongoTemplate.dropCollection("users");
  }

}
