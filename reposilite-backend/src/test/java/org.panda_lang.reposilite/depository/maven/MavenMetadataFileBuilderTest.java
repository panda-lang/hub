package org.panda_lang.reposilite.depository.maven;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.panda_lang.panda.utilities.commons.collection.Sets;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
class MavenMetadataFileBuilderTest {

    private MavenMetadataFile file;

    @BeforeEach
    void setUp() {
        this.file = new MavenMetadataFileBuilder()
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
