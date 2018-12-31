package org.panda_lang.reposilite.profile;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ProfileControllerIntegrationTest {

    @Autowired
    private ProfileController profileController;

    private MockMvc mockMvc;

    @Before
    public void setUp() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(this.profileController).build();
    }

    @Test
    public void profileTest() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/account/jkowalski/"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.account", Matchers.is("jkowalski")));
    }

    @Test
    public void profileWithProjectTest() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/account/jkowalski/panda/"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.account", Matchers.is("jkowalski")))
                .andExpect(jsonPath("$.project", Matchers.is("panda")));
    }

}
