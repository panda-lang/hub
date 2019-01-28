package org.panda_lang.reposilite.auth;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.panda_lang.reposilite.user.UserRegistrationDto;
import org.panda_lang.reposilite.user.UserCrudService;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
@RunWith(JUnitPlatform.class)
class RegistrationControllerTest {

    @InjectMocks
    private RegistrationController registrationController;

    @Mock
    private UserCrudService userCrudService;

    private MockMvc mockMvc;

    @BeforeEach
    void setUp() throws Exception {
        this.mockMvc = MockMvcBuilders.standaloneSetup(this.registrationController).build();
    }

    @Test
    void registrationTest() throws Exception {
        UserRegistrationDto dto = new UserRegistrationDto(
                "test123",
                "test123",
                "test123",
                "test123",
                "test123@test",
                "test123@test"
        );

        this.mockMvc.perform(MockMvcRequestBuilders.post("/api/register")
                .content(dto.toJson().getBytes())
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());
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

        this.mockMvc.perform(MockMvcRequestBuilders.post("/api/register")
                .content(dto.toJson().getBytes())
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
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

        this.mockMvc.perform(MockMvcRequestBuilders.post("/api/register")
                .content(dto.toJson().getBytes())
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
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

        this.mockMvc.perform(MockMvcRequestBuilders.post("/api/register")
                .content(dto.toJson().getBytes())
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
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

        this.mockMvc.perform(MockMvcRequestBuilders.post("/api/register")
                .content(dto.toJson().getBytes())
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
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

        this.mockMvc.perform(MockMvcRequestBuilders.post("/api/register")
                .content(dto.toJson().getBytes())
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }

}
