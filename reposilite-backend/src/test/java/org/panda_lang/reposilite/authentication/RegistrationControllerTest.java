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

package org.panda_lang.reposilite.authentication;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.panda_lang.reposilite.user.UserCrudService;
import org.panda_lang.reposilite.user.UserRegistrationDto;
import org.panda_lang.reposilite.utils.entity.AbstractDto;
import org.panda_lang.reposilite.utils.entity.AbstractDtoUtils;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
@RunWith(JUnitPlatform.class)
class RegistrationControllerTest {

    @InjectMocks
    private RegistrationController registrationController;

    @Mock
    private UserCrudService userCrudService;

    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(this.registrationController).build();
    }

    @Test
    void registrationTest() throws Exception {
        UserRegistrationDto dto = new UserRegistrationDto(
                "username-123",
                "display-name-123",
                "password-123",
                "password-123",
                "test123@test",
                "test123@test"
        );

        perform(dto, status().isCreated());
    }

    @Test
    void shouldReturnBadRequestIfEmpty() throws Exception {
        UserRegistrationDto dto = new UserRegistrationDto(
                "",
                "",
                "",
                "",
                "",
                ""
        );

        perform(dto, status().isBadRequest());
    }

    @Test
    void shouldReturnBadRequestIfUsernameLengthIsLessThan3() throws Exception {
        UserRegistrationDto dto = new UserRegistrationDto(
                "12",
                "test123",
                "test123",
                "test123",
                "test123@test",
                "test123@test"
        );

        perform(dto, status().isBadRequest());
    }

    @Test
    void shouldReturnBadRequestIfPasswordLengthIsLessThan6() throws Exception {
        UserRegistrationDto dto = new UserRegistrationDto(
                "test123",
                "test123",
                "test1",
                "test1",
                "test123@test",
                "test123@test"
        );

        perform(dto, status().isBadRequest());
    }

    @Test
    void shouldReturnBadRequestIfConfirmationDoesNotMatch() throws Exception {
        UserRegistrationDto dto = new UserRegistrationDto(
                "test123",
                "test123",
                "test123",
                "test12",
                "test123@test",
                "test123@test"
        );

        perform(dto, status().isBadRequest());
    }

    @Test
    void shouldReturnBadRequestIfEmailDoesNotMatchPattern() throws Exception {
        UserRegistrationDto dto = new UserRegistrationDto(
                "test123",
                "test123",
                "test123",
                "test123",
                "test123",
                "test123"
        );

        perform(dto, status().isBadRequest());
    }

    private void perform(AbstractDto<?> dto, ResultMatcher resultMatcher) throws Exception {
        AbstractDtoUtils.perform(mockMvc, "/api/register", dto, resultMatcher);
    }

}
