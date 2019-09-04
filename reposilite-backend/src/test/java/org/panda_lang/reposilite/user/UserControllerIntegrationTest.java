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

package org.panda_lang.reposilite.user;

import com.google.common.collect.Sets;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.panda_lang.reposilite.user.role.RoleFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors;
import org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@SpringBootTest
class UserControllerIntegrationTest {

    @Autowired
    private WebApplicationContext applicationContext;

    @Autowired
    private MongoTemplate mongoTemplate;

    @Autowired
    private UserCrudService userService;

    @Autowired
    private RoleFactory roleFactory;

    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.applicationContext)
                .apply(SecurityMockMvcConfigurers.springSecurity())
                .build();
    }

    @Test
    void authenticationTest() throws Exception {
        User user = User.builder()
                .withName("test12312313")
                .withPassword("test123")
                .withRoles(Sets.newHashSet(this.roleFactory.obtainRole("ADMIN")))
                .build();
        this.userService.save(user);

        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/users/me")
                .with(SecurityMockMvcRequestPostProcessors.httpBasic("test12312313", "test123")))
                .andExpect(status().isOk())
                .andDo(mvcResult -> System.out.println("Res: " + mvcResult.getResponse().toString()));
                //.andExpect(jsonPath("$.name", Matchers.is("test12312313")));
    }

    @Test
    void authenticationShouldReturn401WhenBadCredentials() throws Exception {
        User user = new UserBuilder()
                .withName("test12312313")
                .withPassword("test123")
                .build();

        this.userService.save(user);
        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/users/me")
                .with(SecurityMockMvcRequestPostProcessors.httpBasic("test12312313", "test1234")))
                .andExpect(status().isUnauthorized());
    }

    @AfterEach
    void tearDown() {
        this.mongoTemplate.dropCollection("users");
    }

}
