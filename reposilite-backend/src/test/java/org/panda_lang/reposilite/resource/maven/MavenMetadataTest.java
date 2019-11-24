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

import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
class MavenMetadataTest {

    private final static String DEPOSITORY_PATH = StringUtils.replace("/org/panda-lang/panda-utilities/indev-0.8.87/panda-utilities-indev-0.8.87.jar", "/", File.separator);

    @Test
    void getGroupName() {
        MavenMetadata mavenMetadata = MavenMetadata.ofSystemPath(DEPOSITORY_PATH);
        assertEquals(mavenMetadata.getGroupName(), "org.panda-lang");
    }

    @Test
    void getArtifactName() {
        MavenMetadata mavenMetadata = MavenMetadata.ofSystemPath(DEPOSITORY_PATH);
        assertEquals(mavenMetadata.getArtifactName(), "panda-utilities");
    }

    @Test
    void getBuildVersion() {
        MavenMetadata mavenMetadata = MavenMetadata.ofSystemPath(DEPOSITORY_PATH);
        assertEquals(mavenMetadata.getBuildVersion(), "indev-0.8.87");
    }

    @Test
    void getBuildFile() {
        MavenMetadata mavenMetadata = MavenMetadata.ofSystemPath(DEPOSITORY_PATH);
        assertEquals(mavenMetadata.getBuildFile(), "panda-utilities-indev-0.8.87.jar");
    }

}
