package org.panda_lang.reposilite.user.role;

import com.mongodb.BasicDBObject;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.panda_lang.reposilite.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.shell.Shell;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RoleCommandsIntegrationTest {

    @Autowired
    private Shell shell;

    @Autowired
    private MongoTemplate mongoTemplate;

    @Autowired
    private RoleFactory roleFactory;

    @Test
    public void rolesCommandTest() {
        Object result = this.shell.evaluate(() -> "roles");
        assertEquals("", result);
    }

    @Test
    public void setRoleCommandTest() {
        Map<String, Object> userDetails = new HashMap<String, Object>() {{
            this.put("name", "testUser2115");
            this.put("roles", Collections.emptySet());
        }};

        this.mongoTemplate.insert(new BasicDBObject(userDetails), "users");
        Object result = this.shell.evaluate(() -> "chrole testUser2115 ADMIN");
        User user = this.mongoTemplate.findOne(Query.query(Criteria.where("name").is("testUser2115")), User.class);

        assertAll(
                () -> assertNotNull(this.mongoTemplate.findById("ADMIN", Role.class)),
                () -> assertTrue(user.getRoles().toString().contains("ADMIN")),
                () -> assertEquals("Set role `ADMIN` for user: testUser2115", result)
        );
    }

    @Test
    public void setRoleCommandWhenUserNotFound() {
        Object result = this.shell.evaluate(() -> "chrole testUser1337 ADMIN");
        assertEquals("User not found!", result);
    }

    @After
    public void tearDown() throws Exception {
        this.mongoTemplate.dropCollection("users");
        this.mongoTemplate.dropCollection("roles");
    }

}
