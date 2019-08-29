package org.panda_lang.reposilite.depository.maven;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.panda_lang.reposilite.depository.DepositoryEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

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

        Optional<DepositoryEntity> depositoryEntity = mavenDepository.find("org/panda-lang/panda-utilities");
        assertTrue(depositoryEntity.isPresent());
        assertEquals(depositoryEntity.get().getName(), "panda-utilities");
    }

}
