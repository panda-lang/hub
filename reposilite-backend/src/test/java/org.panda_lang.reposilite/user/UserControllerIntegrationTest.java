package org.panda_lang.reposilite.user;

import com.google.common.collect.Sets;
import org.hamcrest.Matchers;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.panda_lang.reposilite.user.role.RoleFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors;
import org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@SpringBootTest
public class UserControllerIntegrationTest {

    @Autowired
    private WebApplicationContext applicationContext;

    @Autowired
    private MongoTemplate mongoTemplate;

    @Autowired
    private UserCrudService userService;

    @Autowired
    private RoleFactory roleFactory;

    private MockMvc mockMvc;

    @Before
    public void setUp() throws Exception {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.applicationContext)
                .apply(SecurityMockMvcConfigurers.springSecurity())
                .build();
    }

    @Test
    public void authenticationTest() throws Exception {
        User user = new UserBuilder()
                .withName("test12312313")
                .withPassword("test123")
                .withRoles(Sets.newHashSet(this.roleFactory.obtainRole("ADMIN")))
                .build();

        this.userService.save(user);
        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/users/me")
                .with(SecurityMockMvcRequestPostProcessors.httpBasic("test12312313", "test123")))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", Matchers.is("test12312313")));
    }

    @Test
    public void authenticationShouldReturn401WhenBadCredentials() throws Exception {
        User user = new UserBuilder()
                .withName("test12312313")
                .withPassword("test123")
                .build();

        this.userService.save(user);
        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/users/me")
                .with(SecurityMockMvcRequestPostProcessors.httpBasic("test12312313", "test1234")))
                .andExpect(status().isUnauthorized());
    }

    @After
    public void tearDown() throws Exception {
        this.mongoTemplate.dropCollection("users");
    }

}
