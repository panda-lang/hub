package org.panda_lang.reposilite.depository.maven;

import org.apache.commons.lang3.StringUtils;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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
class GroupControllerIntegrationTest {

    @Autowired
    @Qualifier("workspaceDirectory")
    private File workspace;

    @Autowired
    private MavenController mavenController;

    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(this.mavenController).build();
    }

    @Test
    void shouldReturn404WhenGroupIsNotPresent() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/repository/maven/releases/pl/panda-lang/"))
                .andExpect(status().isNotFound());
    }

    @Test
    void shouldReturn200WhenGroupPresent() throws Exception {
        String path = StringUtils.replace("repositories/maven/releases/org/panda-lang", "/", File.separator);

        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/repository/maven/releases/org/panda-lang/"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.path", Matchers.is(workspace + File.separator + path)));
    }

}
