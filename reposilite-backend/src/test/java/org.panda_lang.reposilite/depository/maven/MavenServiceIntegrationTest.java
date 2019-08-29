package org.panda_lang.reposilite.depository.maven;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.panda_lang.reposilite.depository.DepositoryEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@RunWith(SpringRunner.class)
class MavenServiceIntegrationTest {

    @Autowired
    private MavenServiceImpl depositoryService;

    @Test
    void getDepositoryTest() {
        Assert.assertNotNull(this.depositoryService.getDepository("releases"));
    }

    @Test
    void getDepositoryEntityTest() {
        Optional<Depository> depository = this.depositoryService.getDepository("releases");
        assertTrue(depository.isPresent());

        Optional<DepositoryEntity> depositoryEntity = depository.get().find("org/panda-lang/panda-utilities");
        assertTrue(depositoryEntity.isPresent());
    }

}
