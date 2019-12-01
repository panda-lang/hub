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

package org.panda_lang.reposilite.resource_fs.maven;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.panda_lang.utilities.commons.collection.Sets;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@RunWith(SpringRunner.class)
class MetadataFileBuilderTest {

    private MetadataFile file;

    @BeforeEach
    void setUp() {
        this.file = new MetadataFileBuilder()
                .withGroupId("test1")
                .withArtifactId("test2")
                .withLastUpdated(0)
                .withLatest("latest")
                .withRelease("release")
                .withVersions(Sets.newHashSet("1.3", "1.4"))
                .build();
    }

    @Test
    void shouldNotBeNull() {
        assertAll(
                () -> assertNotNull(this.file.getGroupId()),
                () -> assertNotNull(this.file.getArtifactId()),
                () -> assertNotNull(this.file.getVersioning().getLatest()),
                () -> assertNotNull(this.file.getVersioning().getRelease()),
                () -> assertNotNull(this.file.getVersioning().getVersions().getVersion())
        );
    }

    @Test
    void toStringTest() {
        assertEquals("MavenMetadataFile{" +
                "groupId='test1', " +
                "artifactId='test2', " +
                "versioning=Versioning{" +
                "release='release', " +
                "latest='latest', versions=Versions{" +
                "version=[1.3, 1.4]}, " +
                "lastUpdated=0}}", this.file.toString());
    }

}
