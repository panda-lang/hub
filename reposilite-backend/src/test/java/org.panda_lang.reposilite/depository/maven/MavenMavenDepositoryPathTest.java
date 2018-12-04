package org.panda_lang.reposilite.depository.maven;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class MavenMavenDepositoryPathTest {

    private final static String DEPOSITORY_PATH = "\\org\\panda-lang\\panda-utilities\\indev-0.8.1\\panda-utilities-indev-0.8.1.jar";

    @Test
    public void groupNameBySystemPathTest() {
        MavenDepositoryPath mavenDepositoryPath = MavenDepositoryPath.ofSystemPath(DEPOSITORY_PATH);
        Assert.assertThat(mavenDepositoryPath.getGroupName(), Matchers.is("org.panda-lang"));
    }

    @Test
    public void artifactIdBySystemPathTest() {
        MavenDepositoryPath mavenDepositoryPath = MavenDepositoryPath.ofSystemPath(DEPOSITORY_PATH);
        Assert.assertThat(mavenDepositoryPath.getArtifactName(), Matchers.is("panda-utilities"));
    }

    @Test
    public void buildVersionBySystemPathTest() {
        MavenDepositoryPath mavenDepositoryPath = MavenDepositoryPath.ofSystemPath(DEPOSITORY_PATH);
        Assert.assertThat(mavenDepositoryPath.getBuildVersion(), Matchers.is("indev-0.8.1"));
    }

    @Test
    public void buildFileBySystemPathTest() {
        MavenDepositoryPath mavenDepositoryPath = MavenDepositoryPath.ofSystemPath(DEPOSITORY_PATH);
        Assert.assertThat(mavenDepositoryPath.getBuildFile(), Matchers.is("panda-utilities-indev-0.8.1.jar"));
    }

}
