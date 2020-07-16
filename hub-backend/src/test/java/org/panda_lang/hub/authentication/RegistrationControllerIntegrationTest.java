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

package org.panda_lang.hub.authentication;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.panda_lang.hub.user.UserRegistrationDto;
import org.panda_lang.hub.utils.AbstractDtoUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(JUnitPlatform.class)
@EnableAutoConfiguration
@SpringBootTest
class RegistrationControllerIntegrationTest {

    @Autowired
    private RegistrationController registrationController;

    @Autowired
    private MongoTemplate mongoTemplate;

    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(this.registrationController).build();
    }

    @Test
    void shouldReturnConflictIfUserAlreadyExists() throws Exception {
        UserRegistrationDto dto = new UserRegistrationDto(
                "test123",
                "test123",
                "test123",
                "test123",
                "test123@test",
                "test123@test"
        );

        AbstractDtoUtils.perform(mockMvc, "/api/register", dto, status().isCreated());
        AbstractDtoUtils.perform(mockMvc, "/api/register", dto, status().isConflict());
    }

    @AfterEach
    void tearDown() {
        this.mongoTemplate.dropCollection("users");
    }

}
