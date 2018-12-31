package org.panda_lang.reposilite.depository.maven.artifact;

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
public class ArtifactControllerIntegrationTest {

    @Autowired
    private MavenDepositoryController mavenDepositoryController;

    private MockMvc mockMvc;

    @Before
    public void setUp() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(this.mavenDepositoryController).build();
    }

    @Test
    public void shouldReturn404WhenArtifactIsNotPresent() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/repository/maven/releases/org/panda-lang/p4nd4-utilities/"))
                .andExpect(status().isNotFound());
    }

    @Test
    public void shouldReturn200WhenArtifactPresent() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/repository/maven/releases/org/panda-lang/panda-utilities/"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.path", Matchers.is("repositories\\maven\\releases\\org\\panda-lang\\panda-utilities")))
                .andExpect(jsonPath("$.files[0]", Matchers.is("indev-0.8.0")))
                .andExpect(jsonPath("$.files[1]", Matchers.is("indev-0.8.1")))
                .andExpect(jsonPath("$.files[2]", Matchers.is("indev-0.8.731")))
                .andExpect(jsonPath("$.files[3]", Matchers.is("indev-0.8.87")))
                .andExpect(jsonPath("$.files[4]", Matchers.is("maven-metadata-local.xml")))
                .andExpect(jsonPath("$.files[5]", Matchers.is("maven-metadata-panda-repository.xml")));
    }

}
