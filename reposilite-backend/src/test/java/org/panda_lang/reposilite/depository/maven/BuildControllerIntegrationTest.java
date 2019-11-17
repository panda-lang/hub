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

package org.panda_lang.reposilite.depository.maven;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
class BuildControllerIntegrationTest {

    @Autowired
    private MavenController mavenController;

    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(this.mavenController).build();
    }

    @Test
    void shouldReturn404WhenBuildIsNotPresent() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/repository/maven/releases/org/panda-lang/panda-utilities/indev-333.8.0"))
                .andExpect(status().isNotFound());
    }

    @Test
    void shouldReturn200AndChildNodesWhenBuildPresent() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/repository/maven/releases/org/panda-lang/panda-utilities/indev-0.8.0"))
                .andExpect(status().isOk())
                .andExpect(content().json("[ 'panda-utilities-indev-0.8.0.jar', 'panda-utilities-indev-0.8.0.pom' ]"));
    }

}
