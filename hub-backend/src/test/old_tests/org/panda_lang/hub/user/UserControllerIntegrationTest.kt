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

import com.google.common.collect.Sets
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Test
import org.panda_lang.hub.AbstractContextIntegrationTest
import org.panda_lang.hub.user.role.RoleFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import kotlin.Throws

internal class UserControllerIntegrationTest : AbstractContextIntegrationTest() {
    @Autowired
    private val userService: UserService? = null

    @Autowired
    private val roleFactory: RoleFactory? = null
    @Test
    @Throws(Exception::class)
    fun authenticationTest() {
        val user: User = User.builder()
            .withName("test123")
            .withPassword("test123")
            .withRoles(Sets.newHashSet(roleFactory.obtainRole("ADMIN")))
            .build()
        userService.initializeUser(user)
        super.getMockMvc().perform(getAuthenticated("/api/users/me", "test123", "test123"))
            .andExpect(status().isOk())
    }

    @Test
    @Throws(Exception::class)
    fun authenticationShouldReturn401WhenNotLogged() {
        super.perform("/api/users/me")
            .andExpect(status().isUnauthorized())
    }

    @AfterEach
    fun drop() {
        super.drop("users")
    }
}
