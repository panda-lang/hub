package org.panda_lang.reposilite.user;

import com.mongodb.BasicDBObject;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.shell.Shell;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserCommandsIntegrationTest {

    @Autowired
    private Shell shell;

    @Autowired
    private MongoTemplate mongoTemplate;

    @Test
    public void userAddCommandTest() {
        Object result = this.shell.evaluate(() -> "useradd testUser123");

        Query query = new Query();
        query.addCriteria(Criteria.where("name").is("testUser123"));

        assertAll(
                () -> assertTrue(this.mongoTemplate.exists(query, "users")),
                () -> assertEquals("Created user: testUser123", result)
        );
    }

    @Test
    public void userAddAlreadyExistsTest() {
        Map<String, Object> userDetails = new HashMap<String, Object>() {{
            this.put("name", "testUser");
        }};

        this.mongoTemplate.insert(new BasicDBObject(userDetails), "users");
        Object result = this.shell.evaluate(() -> "useradd testUser");

        assertEquals("User already exists", result);
    }

    @Test
    public void passwdCommandTest() {
        Map<String, Object> userDetails = new HashMap<String, Object>() {{
            this.put("name", "testUser133");
        }};

        BasicDBObject userDbObject = new BasicDBObject(userDetails);
        this.mongoTemplate.insert(userDbObject, "users");


        Object result = this.shell.evaluate(() -> "passwd testUser133 test");
        User user = this.mongoTemplate.findOne(new Query().addCriteria(Criteria.where("name").is("testUser133")), User.class, "users");

        assertAll(
                () -> assertEquals("Set password for user: testUser133", result),
                () -> assertNotNull(user.getPassword())
        );
    }

    @Test
    public void passwdUserNotFoundTest() {
        Object result = this.shell.evaluate(() -> "passwd testUser135 test");
        assertEquals("User not found!", result);
    }

    @After
    public void tearDown() throws Exception {
        this.mongoTemplate.dropCollection("users");
    }

}
