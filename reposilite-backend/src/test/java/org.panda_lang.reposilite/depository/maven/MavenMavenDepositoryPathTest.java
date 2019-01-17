package org.panda_lang.reposilite.depository.maven;

import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
class MavenMavenDepositoryPathTest {

    private final static String DEPOSITORY_PATH = StringUtils.replace("/org/panda-lang/panda-utilities/indev-0.8.1/panda-utilities-indev-0.8.1.jar", "/", File.separator);

    @Test
    void groupNameBySystemPathTest() {
        MavenDepositoryPath mavenDepositoryPath = MavenDepositoryPath.ofSystemPath(DEPOSITORY_PATH);
        assertEquals(mavenDepositoryPath.getGroupName(), "org.panda-lang");
    }

    @Test
    void artifactIdBySystemPathTest() {
        MavenDepositoryPath mavenDepositoryPath = MavenDepositoryPath.ofSystemPath(DEPOSITORY_PATH);
        assertEquals(mavenDepositoryPath.getArtifactName(), "panda-utilities");
    }

    @Test
    void buildVersionBySystemPathTest() {
        MavenDepositoryPath mavenDepositoryPath = MavenDepositoryPath.ofSystemPath(DEPOSITORY_PATH);
        assertEquals(mavenDepositoryPath.getBuildVersion(), "indev-0.8.1");
    }

    @Test
    void buildFileBySystemPathTest() {
        MavenDepositoryPath mavenDepositoryPath = MavenDepositoryPath.ofSystemPath(DEPOSITORY_PATH);
        assertEquals(mavenDepositoryPath.getBuildFile(), "panda-utilities-indev-0.8.1.jar");
    }

}
