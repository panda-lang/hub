package org.panda_lang.reposilite.depository;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class DepositoryPathTest {

    private final static String DEPOSITORY_PATH = "\\org\\panda-lang\\panda-utilities\\indev-0.8.1\\panda-utilities-indev-0.8.1.jar";

    @Test
    public void groupNameBySystemPathTest() {
        DepositoryPath depositoryPath = DepositoryPath.ofSystemPath(DEPOSITORY_PATH);
        Assert.assertThat(depositoryPath.getGroupName(), Matchers.is("org.panda-lang"));
    }

    @Test
    public void artifactIdBySystemPathTest() {
        DepositoryPath depositoryPath = DepositoryPath.ofSystemPath(DEPOSITORY_PATH);
        Assert.assertThat(depositoryPath.getArtifactName(), Matchers.is("panda-utilities"));
    }

    @Test
    public void buildVersionBySystemPathTest() {
        DepositoryPath depositoryPath = DepositoryPath.ofSystemPath(DEPOSITORY_PATH);
        Assert.assertThat(depositoryPath.getBuildVersion(), Matchers.is("indev-0.8.1"));
    }

    @Test
    public void buildFileBySystemPathTest() {
        DepositoryPath depositoryPath = DepositoryPath.ofSystemPath(DEPOSITORY_PATH);
        Assert.assertThat(depositoryPath.getBuildFile(), Matchers.is("panda-utilities-indev-0.8.1.jar"));
    }

}
