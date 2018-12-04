package org.panda_lang.reposilite.depository.maven.group;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.panda_lang.reposilite.depository.maven.MavenDepositoryController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GroupControllerTest {

    @Autowired
    private MavenDepositoryController mavenDepositoryController;

    private MockMvc mockMvc;

    @Before
    public void setUp() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(this.mavenDepositoryController).build();
    }

    @Test
    public void shouldReturn404WhenGroupIsNotPresent() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/repository/maven/releases/pl/panda-lang/"))
                .andExpect(status().isNotFound());
    }

    @Test
    public void shouldReturn200WhenGroupPresent() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/repository/maven/releases/org/panda-lang/"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.path", Matchers.is("repositories\\maven\\releases\\org\\panda-lang")))
                .andExpect(jsonPath("$.files[0]", Matchers.is("panda-utilities")));
    }

}
