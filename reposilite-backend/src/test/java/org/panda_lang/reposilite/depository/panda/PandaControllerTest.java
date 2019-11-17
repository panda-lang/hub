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

package org.panda_lang.reposilite.depository.panda;

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
class PandaControllerTest {

    private static final String PATH = "/api/repository/panda";

    @Autowired
    private PandaController controller;

    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(this.controller).build();
    }

    @Test
    void put() {

    }

    @Test
    void shouldReturn404WhenDepositoryIsNotPresent() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get(PATH + "/unknown_project"))
                .andExpect(status().isNotFound());
    }

    @Test
    void shouldReturn200AndChildNodesWhenDepositoryPresent() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get(PATH + "/dzikoysk/"))
                .andExpect(status().isOk())
                .andExpect(content().json("[ 'project1', 'project2' ]"));
    }

}