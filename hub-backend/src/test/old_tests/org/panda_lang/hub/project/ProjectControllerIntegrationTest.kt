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
package org.panda_lang.hub.project

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.collection.IsCollectionWithSize.hasSize
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.panda_lang.hub.AbstractContextIntegrationTest
import org.panda_lang.hub.user.User
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.content
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import kotlin.Throws

internal class ProjectControllerIntegrationTest : AbstractContextIntegrationTest() {
    @Autowired
    private val projectService: ProjectService? = null
    @BeforeEach
    fun prepare() {
        projectService.save(Project("PROJECT NAME", User.builder().withName("onlypanda").build(), "uri", "website"))
    }

    @Test
    @Throws(Exception::class)
    fun shouldReturnNoContent() {
        super.perform("/api/projects")
            .andExpect(status().isNoContent())
    }

    @Test
    @Throws(Exception::class)
    fun shouldReturn200AndProjectsCount() {
        super.perform("/api/projects/count")
            .andExpect(status().isOk())
            .andExpect(content().json("1"))
    }

    @Test
    @Throws(Exception::class)
    fun shouldReturn200AndAmountOfPages() {
        super.perform("/api/projects/page")
            .andExpect(status().isOk())
            .andExpect(content().json("1"))
    }

    @Test
    @Throws(Exception::class)
    fun shouldReturn200AndProjectPage() {
        super.perform("/api/projects/page/0")
            .andExpect(status().isOk())
            .andExpect(jsonPath("$").isArray())
            .andExpect(jsonPath("$", hasSize(1)))
            .andExpect(jsonPath("$[0].name", `is`("PROJECT NAME")))
    }

    @Test
    @Throws(Exception::class)
    fun shouldReturn200AndAllUserProjects() {
        super.perform("/api/projects/user/onlypanda")
            .andExpect(status().isOk())
            .andExpect(jsonPath("$").isArray())
            .andExpect(jsonPath("$", hasSize(1)))
            .andExpect(jsonPath("$[0].name", `is`("PROJECT NAME")))
    }

    @AfterEach
    fun drop() {
        super.drop("projects")
    }
}
