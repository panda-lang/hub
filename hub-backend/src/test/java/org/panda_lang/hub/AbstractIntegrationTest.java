/*
 * Copyright (c) 2020 Hub Team of panda-lang organization
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

package org.panda_lang.hub;

import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@RunWith(SpringRunner.class)
@SpringBootTest
public abstract class AbstractIntegrationTest {

    private MockMvc mockMvc;

    protected abstract MockMvc setup();

    @BeforeEach
    protected void setUp() {
        this.mockMvc = setup();
    }

    protected ResultActions perform(String uri) throws Exception {
        return getMockMvc().perform(MockMvcRequestBuilders.get(uri));
    }

    protected MockHttpServletRequestBuilder getAuthenticated(String uri, String username, String password) {
        return MockMvcRequestBuilders.get(uri).with(SecurityMockMvcRequestPostProcessors.httpBasic(username, password));
    }

    protected MockMvc getMockMvc() {
        return mockMvc;
    }

}
