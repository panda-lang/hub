package org.panda_lang.reposilite.depository.maven;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.panda_lang.reposilite.depository.DepositoryEntity;
import org.panda_lang.reposilite.depository.DepositoryNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class MavenMavenDepositoryRepositoryTest {

    @Autowired
    private MavenDepositoryRepository mavenDepositoryRepository;

    @Test
    public void findRepositoryByNameShouldReturnExceptionWhenNotFoundTest() {
        Assertions.assertThrows(DepositoryNotFoundException.class, () -> this.mavenDepositoryRepository.findDepositoryByName("FailReleases"));
    }

    @Test
    public void findRepositoryByNameTest() {
        Assert.assertNotNull(this.mavenDepositoryRepository.findDepositoryByName("releases"));
    }

    @Test
    public void findRepositoryNodeByNameTest() {
        MavenDepository mavenDepository = this.mavenDepositoryRepository.findDepositoryByName("releases");
        DepositoryEntity depositoryEntity = this.mavenDepositoryRepository.findEntityByURLPath(mavenDepository, "org/panda-lang/panda-utilities");

        Assert.assertThat(mavenDepository, Matchers.notNullValue());
        Assert.assertThat(depositoryEntity.getName(), Matchers.is("panda-utilities"));
    }

}
