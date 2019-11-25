/*
 * Copyright (c) 2018-2019 Reposilite Team
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

package org.panda_lang.reposilite.user;

import com.google.common.collect.Sets;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.panda_lang.reposilite.AbstractContextIntegrationTest;
import org.panda_lang.reposilite.user.role.RoleFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class UserControllerIntegrationTest extends AbstractContextIntegrationTest {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleFactory roleFactory;

    @Test
    void authenticationTest() throws Exception {
        User user = User.builder()
                .withName("test123")
                .withPassword("test123")
                .withRoles(Sets.newHashSet(roleFactory.obtainRole("ADMIN")))
                .build();
        userService.save(user);

        super.getMockMvc().perform(get("/api/users/me").with(SecurityMockMvcRequestPostProcessors.httpBasic("test123", "test123")))
                .andExpect(status().isOk());
    }

    @Test
    void authenticationShouldReturn401WhenNotLogged() throws Exception {
        super.perform("/api/users/me")
                .andExpect(status().isUnauthorized());
    }

    @AfterEach
    void drop() {
        super.drop("users");
    }

}
