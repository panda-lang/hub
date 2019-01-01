package org.panda_lang.reposilite.auth;

import com.google.common.collect.Sets;
import com.mongodb.BasicDBObject;
import org.hamcrest.Matchers;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.panda_lang.reposilite.user.UserAuthenticationDto;
import org.panda_lang.reposilite.user.role.RoleFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.http.MediaType;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.HashMap;
import java.util.Map;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@EnableAutoConfiguration
public class AuthenticationControllerIntegrationTest {

    @Autowired
    private AuthenticationController authenticationController;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private RoleFactory roleFactory;

    @Autowired
    private MongoTemplate mongoTemplate;

    private MockMvc mockMvc;
    private BasicDBObject user;

    @Before
    public void setUp() throws Exception {
        this.mockMvc = MockMvcBuilders.standaloneSetup(this.authenticationController).build();

        Map<String, Object> userDetails = new HashMap<String, Object>() {{
            this.put("name", "#s;7>.r{SQp;7>.r{SQp-]M)s~_S");
            this.put("password", AuthenticationControllerIntegrationTest.this.passwordEncoder.encode("test123"));
            this.put("roles", Sets.newHashSet(
                    AuthenticationControllerIntegrationTest.this.roleFactory.obtainRole("USER"),
                    AuthenticationControllerIntegrationTest.this.roleFactory.obtainRole("ADMIN")
            ));
        }};

        this.user = new BasicDBObject(userDetails);
        this.mongoTemplate.insert(this.user, "users");
    }

    @After
    public void tearDown() throws Exception {
        if (this.user != null) {
            this.mongoTemplate.remove(this.user, "users");
        }
    }

    @Test
    public void successAuthenticationTest() throws Exception {
        UserAuthenticationDto dto = new UserAuthenticationDto("#s;7>.r{SQp;7>.r{SQp-]M)s~_S", "test123");

        this.mockMvc.perform(MockMvcRequestBuilders.post("/api/authenticate")
                .contentType(MediaType.APPLICATION_JSON)
                .content(dto.toJson().getBytes()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", Matchers.is("#s;7>.r{SQp;7>.r{SQp-]M)s~_S")));
    }

    @Test
    public void failureAuthenticationTest() throws Exception {
        UserAuthenticationDto dto = new UserAuthenticationDto("#s;7>.r{SQp;7>.r{SQp-]M)s~_S", "test1234");

        this.mockMvc.perform(MockMvcRequestBuilders.post("/api/authenticate")
                .contentType(MediaType.APPLICATION_JSON)
                .content(dto.toJson().getBytes()))
                .andExpect(status().isUnauthorized());
    }

}
