package org.panda_lang.reposilite.depository.maven.build;

import org.apache.commons.lang3.StringUtils;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.panda_lang.reposilite.depository.maven.MavenDepositoryController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.io.File;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
class BuildControllerIntegrationTest {

    @Autowired
    private MavenDepositoryController mavenDepositoryController;

    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(this.mavenDepositoryController).build();
    }

    @Test
    void shouldReturn404WhenBuildIsNotPresent() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/repository/maven/releases/org/panda-lang/panda-utilities/indev-333.8.0"))
                .andExpect(status().isNotFound());
    }

    @Test
    void shouldReturn200WhenBuildPresent() throws Exception {
        String path = StringUtils.replace("repositories/maven/releases/org/panda-lang/panda-utilities/indev-0.8.0", "/", File.separator);

        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/repository/maven/releases/org/panda-lang/panda-utilities/indev-0.8.0"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.path", Matchers.is(path)))
                .andExpect(jsonPath("$.files[0]", Matchers.is("panda-utilities-indev-0.8.0.jar")))
                .andExpect(jsonPath("$.files[1]", Matchers.is("panda-utilities-indev-0.8.0.pom")))
                .andExpect(jsonPath("$.files[2]", Matchers.is("_remote.repositories")));
    }

}
