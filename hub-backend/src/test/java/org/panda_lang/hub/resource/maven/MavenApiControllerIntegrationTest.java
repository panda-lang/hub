/*
 * Copyright (c) 2018-2019 Hub Team
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.panda_lang.hub.resource.maven;

import com.google.common.collect.Sets;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import org.panda_lang.hub.AbstractContextIntegrationTest;
import org.panda_lang.hub.user.User;
import org.panda_lang.hub.user.UserService;
import org.panda_lang.hub.user.role.RoleFactory;
import org.panda_lang.utilities.commons.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.io.File;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

final class MavenApiControllerIntegrationTest extends AbstractContextIntegrationTest {

    @TempDir
    static File resourcesDirectory;

    @TestConfiguration
    static class TestConfig {

        @Primary
        @Bean
        public File resourcesDirectory() {
            return resourcesDirectory;
        }

    }

    @Autowired
    private UserService userService;

    @Autowired
    private RoleFactory roleFactory;

    @Autowired
    private MavenService mavenService;

    @Autowired
    private MavenApiController mavenApiController;

    @Test
    void shouldReturn202AndUploadFile() throws Exception {
        userService.initializeUser(User.builder()
                .withName("userA")
                .withPassword("passwordA")
                .withRoles(Sets.newHashSet(roleFactory.obtainRole("ADMIN")))
                .build());

        MockMultipartFile mockMultipartFile = new MockMultipartFile("data", "build-version.jar", "java/application", "test data".getBytes());

        super.getMockMvc().perform(MockMvcRequestBuilders.multipart("/api/resources/maven/repositoryA/groupA/groupB/artifactA/versionA/artifactA-versionA.jar")
                .file(mockMultipartFile)
                .with(SecurityMockMvcRequestPostProcessors.httpBasic("userA", "passwordA"))
                .with(request -> {
                    request.setMethod("PUT");
                    return request;
                })
        ).andExpect(status().isAccepted());

        assertTrue(mavenService.findByName("repositoryA").isPresent());
        assertTrue(FileUtils.contains(resourcesDirectory.listFiles(), "maven"));
    }

}
