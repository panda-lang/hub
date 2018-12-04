package org.panda_lang.reposilite.depository.maven;

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

@RunWith(SpringRunner.class)
@SpringBootTest
public class MavenMavenDepositoryControllerTest {

    @Autowired
    private MavenDepositoryController mavenDepositoryController;

    private MockMvc mockMvc;

    @Before
    public void setUp() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(this.mavenDepositoryController).build();
    }

    @Test
    public void shouldReturn404WhenDepositoryIsNotPresent() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/repository/{repository}", "failableRepository"))
                .andExpect(status().isNotFound());
    }

    @Test
    public void shouldReturn200WhenDepositoryPresent() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/repository/releases/"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", Matchers.is("releases")));
    }

}
