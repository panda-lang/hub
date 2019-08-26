package org.panda_lang.reposilite.depository.maven;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.panda_lang.reposilite.depository.DepositoryEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

@SpringBootTest
@RunWith(SpringRunner.class)
class MavenMavenDepositoryRepositoryIntegrationTest {

    @Autowired
    private MavenDepositoryRepository mavenDepositoryRepository;

    @Test
    void findRepositoryByNameShouldReturnNullWhenNotFoundTest() {
        assertNull(mavenDepositoryRepository.findDepositoryByName("FailReleases"));
    }

    @Test
    void findRepositoryByNameTest() {
        assertNotNull(this.mavenDepositoryRepository.findDepositoryByName("releases"));
    }

    @Test
    void findRepositoryNodeByNameTest() {
        MavenDepository mavenDepository = this.mavenDepositoryRepository.findDepositoryByName("releases");
        assertNotNull(mavenDepository);

        DepositoryEntity depositoryEntity = mavenDepository.find("org/panda-lang/panda-utilities");
        assertNotNull(depositoryEntity);
        assertEquals(depositoryEntity.getName(), "panda-utilities");
    }

}
