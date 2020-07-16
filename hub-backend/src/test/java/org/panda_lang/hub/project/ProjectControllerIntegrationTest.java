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

package org.panda_lang.hub.project;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.panda_lang.hub.AbstractContextIntegrationTest;
import org.panda_lang.hub.user.User;
import org.springframework.beans.factory.annotation.Autowired;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

final class ProjectControllerIntegrationTest extends AbstractContextIntegrationTest {

    @Autowired
    private ProjectService projectService;

    @BeforeEach
    void prepare() {
        projectService.save(new Project("PROJECT NAME", User.builder().withName("onlypanda").build(), "uri", "website"));
    }

    @Test
    void shouldReturnNoContent() throws Exception {
        super.perform("/api/projects")
                .andExpect(status().isNoContent());
    }

    @Test
    void shouldReturn200AndProjectsCount() throws Exception {
        super.perform("/api/projects/count")
                .andExpect(status().isOk())
                .andExpect(content().json("1"));
    }

    @Test
    void shouldReturn200AndAmountOfPages() throws Exception {
        super.perform("/api/projects/page")
                .andExpect(status().isOk())
                .andExpect(content().json("1"));
    }

    @Test
    void shouldReturn200AndProjectPage() throws Exception {
        super.perform("/api/projects/page/0")
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].name", is("PROJECT NAME")));
    }

    @Test
    void shouldReturn200AndAllUserProjects() throws Exception {
        super.perform("/api/projects/user/onlypanda")
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].name", is("PROJECT NAME")));
    }

    @AfterEach
    void drop() {
        super.drop("projects");
    }

}
