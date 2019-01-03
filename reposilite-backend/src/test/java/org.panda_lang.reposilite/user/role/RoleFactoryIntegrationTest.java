package org.panda_lang.reposilite.user.role;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RoleFactoryIntegrationTest {

    @Autowired
    private RoleFactory roleFactory;

    @Autowired
    private MongoTemplate mongoTemplate;

    @Test
    public void obtainNewRoleTest() {
        Role role = this.roleFactory.obtainRole("SUPER_VIP");
        assertAll(
                () -> assertNotNull(role),
                () -> assertNotNull(this.mongoTemplate.findById("SUPER_VIP", Role.class))
        );
    }

    @After
    public void tearDown() throws Exception {
        this.mongoTemplate.dropCollection("roles");
    }

}
