package org.panda_lang.reposilite.depository;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class DepositoryRepositoryTest {

    @Autowired
    private DepositoryRepository depositoryRepository;

    @Test
    public void findRepositoryByNameShouldReturnExceptionWhenNotFoundTest() {
        Assertions.assertThrows(DepositoryNotFoundException.class, () -> this.depositoryRepository.findDepositoryByName("FailReleases"));
    }

    @Test
    public void findRepositoryByNameTest() {
        Assert.assertNotNull(this.depositoryRepository.findDepositoryByName("releases"));
    }

    @Test
    public void findRepositoryNodeByNameTest() {
        Depository depository = this.depositoryRepository.findDepositoryByName("releases");
        DepositoryEntity depositoryEntity = this.depositoryRepository.findEntityByURLPath(depository, "org/panda-lang/panda-utilities");

        Assert.assertThat(depository, Matchers.notNullValue());
        Assert.assertThat(depositoryEntity.getName(), Matchers.is("panda-utilities"));
    }

}
