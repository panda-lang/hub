package org.panda_lang.reposilite.depository.maven;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.panda_lang.reposilite.depository.DepositoryEntity;
import org.panda_lang.reposilite.depository.DepositoryNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@RunWith(SpringRunner.class)
class MavenMavenDepositoryRepositoryIntegrationTest {

    @Autowired
    private MavenDepositoryRepository mavenDepositoryRepository;

    @Test
    void findRepositoryByNameShouldReturnExceptionWhenNotFoundTest() {
        assertThrows(DepositoryNotFoundException.class, () -> this.mavenDepositoryRepository.findDepositoryByName("FailReleases"));
    }

    @Test
    void findRepositoryByNameTest() {
        assertNotNull(this.mavenDepositoryRepository.findDepositoryByName("releases"));
    }

    @Test
    void findRepositoryNodeByNameTest() {
        MavenDepository mavenDepository = this.mavenDepositoryRepository.findDepositoryByName("releases");
        DepositoryEntity depositoryEntity = this.mavenDepositoryRepository.findEntityByURLPath(mavenDepository, "org/panda-lang/panda-utilities");

        assertAll(
                () -> assertNotNull(mavenDepository),
                () -> assertEquals(depositoryEntity.getName(), "panda-utilities")
        );
    }

}
