package org.panda_lang.reposilite.auth;

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
import org.panda_lang.reposilite.utils.AbstractDto;
import org.panda_lang.reposilite.utils.AbstractDtoUtils;
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
