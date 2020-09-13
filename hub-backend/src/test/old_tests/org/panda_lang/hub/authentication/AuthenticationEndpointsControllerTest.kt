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
import org.panda_lang.hub.user.UserFacade
import org.panda_lang.hub.utils.AbstractDtoUtils
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.setup.MockMvcBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import kotlin.Throws

@ExtendWith(MockitoExtension::class)
@RunWith(JUnitPlatform::class)
internal class AuthenticationEndpointsControllerTest {
    @InjectMocks
    private val authenticationEndpointsController: AuthenticationEndpointsController? = null

    @Mock
    private val userFacade: UserFacade? = null

    @Mock
    private val authenticationManager: AuthenticationManager? = null

    @Mock
    private val authenticationTokenCreator: AuthenticationTokenCreator? = null
    private var mockMvc: MockMvc? = null
    @BeforeEach
    fun setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(authenticationEndpointsController).build()
    }

    @Test
    @Throws(Exception::class)
    fun registerUser() {
        val signUpDto = SignUpDto(
                "username12",
                "Username",
                "test@email.com",
                "passwd12"
        )
        AbstractDtoUtils.perform(mockMvc, "/api/users/signup", signUpDto, status().isCreated())
    }

    @Test
    @Throws(Exception::class)
    fun authenticateUser() {
        authenticationEndpointsController.registerUser(SignUpDto(
                "username-sign",
                "Username Sign",
                "username-sign@emailcom",
                "passwd12"
        ))
        val signInDto = SignInDto("username-sign", "passwd12")
        AbstractDtoUtils.perform(mockMvc, "/api/users/signin", signInDto, status().isOk())
    }
}