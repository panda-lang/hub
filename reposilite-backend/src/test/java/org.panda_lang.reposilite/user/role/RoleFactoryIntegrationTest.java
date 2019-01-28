package org.panda_lang.reposilite.user.role;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class RoleFactoryIntegrationTest {

    @Autowired
    private RoleFactory roleFactory;

    @Autowired
    private MongoTemplate mongoTemplate;

    @Test
    void obtainNewRoleTest() {
        Role role = this.roleFactory.obtainRole("SUPER_VIP");
        assertAll(
                () -> assertNotNull(role),
                () -> assertNotNull(this.mongoTemplate.findById("SUPER_VIP", Role.class))
        );
    }

    @AfterEach
    void tearDown() throws Exception {
        this.mongoTemplate.dropCollection("roles");
    }

}
