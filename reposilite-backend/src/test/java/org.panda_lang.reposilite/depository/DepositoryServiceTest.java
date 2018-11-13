package org.panda_lang.reposilite.depository;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class DepositoryServiceTest {

    @Autowired
    private DepositoryServiceImpl depositoryService;

    @Test
    public void getDepositoryTest() {
        Assert.assertNotNull(this.depositoryService.getDepository("releases"));
    }

    @Test
    public void getDepositoryEntityTest() {
        Depository depository = this.depositoryService.getDepository("releases");
        DepositoryEntity depositoryEntity = this.depositoryService.getDepositoryEntity(depository, "org/panda-lang/panda-utilities");

        Assert.assertNotNull(depositoryEntity);
    }
}
