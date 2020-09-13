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
package org.panda_lang.hub.authentication

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.junit.platform.runner.JUnitPlatform
import org.junit.runner.RunWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.junit.jupiter.MockitoExtension
import org.panda_lang.hub.user.UserService
import org.panda_lang.hub.user.UserRegistrationDto
import org.panda_lang.hub.utils.entity.AbstractDto
import org.panda_lang.hub.utils.AbstractDtoUtils
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.ResultMatcher
import org.springframework.test.web.servlet.setup.MockMvcBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import kotlin.Throws

@ExtendWith(MockitoExtension::class)
@RunWith(JUnitPlatform::class)
internal class RegistrationControllerTest {
    @InjectMocks
    private val registrationController: RegistrationController? = null

    @Mock
    private val userService: UserService? = null
    private var mockMvc: MockMvc? = null
    @BeforeEach
    fun setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(registrationController).build()
    }

    @Test
    @Throws(Exception::class)
    fun registrationTest() {
        val dto = UserRegistrationDto(
                "username-123",
                "display-name-123",
                "password-123",
                "password-123",
                "test123@test",
                "test123@test"
        )
        perform(dto, status().isCreated())
    }

    @Test
    @Throws(Exception::class)
    fun shouldReturnBadRequestIfEmpty() {
        val dto = UserRegistrationDto(
                "",
                "",
                "",
                "",
                "",
                ""
        )
        perform(dto, status().isBadRequest())
    }

    @Test
    @Throws(Exception::class)
    fun shouldReturnBadRequestIfUsernameLengthIsLessThan3() {
        val dto = UserRegistrationDto(
                "12",
                "test123",
                "test123",
                "test123",
                "test123@test",
                "test123@test"
        )
        perform(dto, status().isBadRequest())
    }

    @Test
    @Throws(Exception::class)
    fun shouldReturnBadRequestIfPasswordLengthIsLessThan6() {
        val dto = UserRegistrationDto(
                "test123",
                "test123",
                "test1",
                "test1",
                "test123@test",
                "test123@test"
        )
        perform(dto, status().isBadRequest())
    }

    @Test
    @Throws(Exception::class)
    fun shouldReturnBadRequestIfConfirmationDoesNotMatch() {
        val dto = UserRegistrationDto(
                "test123",
                "test123",
                "test123",
                "test12",
                "test123@test",
                "test123@test"
        )
        perform(dto, status().isBadRequest())
    }

    @Test
    @Throws(Exception::class)
    fun shouldReturnBadRequestIfEmailDoesNotMatchPattern() {
        val dto = UserRegistrationDto(
                "test123",
                "test123",
                "test123",
                "test123",
                "test123",
                "test123"
        )
        perform(dto, status().isBadRequest())
    }

    @Throws(Exception::class)
    private fun perform(dto: AbstractDto<*>, resultMatcher: ResultMatcher) {
        AbstractDtoUtils.perform(mockMvc, "/api/register", dto, resultMatcher)
    }
}