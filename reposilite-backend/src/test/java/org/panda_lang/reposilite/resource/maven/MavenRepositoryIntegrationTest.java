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

package org.panda_lang.reposilite.resource.maven;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.panda_lang.reposilite.resource.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@RunWith(SpringRunner.class)
class MavenRepositoryIntegrationTest {

    @Autowired
    private MavenRepository mavenRepository;

    @Test
    void findRepositoryByNameShouldReturnNullWhenNotFoundTest() {
        assertFalse(mavenRepository.findEntityByName("FailReleases").isPresent());
    }

    @Test
    void findRepositoryByNameTest() {
        assertTrue(this.mavenRepository.findEntityByName("releases").isPresent());
    }

    @Test
    void findRepositoryNodeByNameTest() {
        Optional<RepositoryResource> repository = this.mavenRepository.findEntityByName("releases");
        assertTrue(repository.isPresent());

        Optional<Resource> resource = repository.get().find("org/panda-lang/panda-utilities");
        assertTrue(resource.isPresent());
        assertEquals(resource.get().getName(), "panda-utilities");
    }

}
