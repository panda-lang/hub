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

package org.panda_lang.reposilite.depository.maven;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.panda_lang.reposilite.depository.DepositoryEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@RunWith(SpringRunner.class)
class MavenRepositoryIntegrationTest {

    @Autowired
    private MavenRepository mavenRepository;

    @Test
    void findRepositoryByNameShouldReturnNullWhenNotFoundTest() {
        assertNull(mavenRepository.findDepositoryByName("FailReleases"));
    }

    @Test
    void findRepositoryByNameTest() {
        assertNotNull(this.mavenRepository.findDepositoryByName("releases"));
    }

    @Test
    void findRepositoryNodeByNameTest() {
        Depository depository = this.mavenRepository.findDepositoryByName("releases");
        assertNotNull(depository);

        Optional<DepositoryEntity> depositoryEntity = depository.find("org/panda-lang/panda-utilities");
        assertTrue(depositoryEntity.isPresent());
        assertEquals(depositoryEntity.get().getName(), "panda-utilities");
    }

}
