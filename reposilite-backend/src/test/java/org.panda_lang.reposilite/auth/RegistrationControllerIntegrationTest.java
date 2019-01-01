package org.panda_lang.reposilite.auth;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.panda_lang.reposilite.user.UserRegistrationDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@EnableAutoConfiguration
@SpringBootTest
public class RegistrationControllerIntegrationTest {

    @Autowired
    private RegistrationController registrationController;

    @Autowired
    private MongoTemplate mongoTemplate;

    private MockMvc mockMvc;

    @Before
    public void setUp() throws Exception {
        this.mockMvc = MockMvcBuilders.standaloneSetup(this.registrationController).build();
    }

    @Test
    public void shouldReturnConflictIfUserAlreadyExists() throws Exception {
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

        this.mockMvc.perform(MockMvcRequestBuilders.post("/api/register")
                .content(dto.toJson().getBytes())
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isConflict());
    }

    @After
    public void tearDown() throws Exception {
        this.mongoTemplate.dropCollection("users");
    }

}
