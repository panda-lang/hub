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

package org.panda_lang.reposilite;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

public abstract class AbstractContextIntegrationTest extends AbstractIntegrationTest {

    @Autowired
    private WebApplicationContext applicationContext;

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    protected MockMvc setup() {
        return MockMvcBuilders.webAppContextSetup(this.applicationContext)
                .apply(SecurityMockMvcConfigurers.springSecurity())
                .build();
    }

    protected void drop(String name) {
        mongoTemplate.getCollection(name).drop();
    }

    protected WebApplicationContext getApplicationContext() {
        return applicationContext;
    }

}
