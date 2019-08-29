package org.panda_lang.reposilite.user;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
class UserRegistrationDtoTest {

    @Test
    void toEntityTest() {
        User user = new UserRegistrationDto("test", "test displayName", "test", "test",
                "test@test", "test@test").toEntity();

        assertEquals("User{" +
                "identifier=null, " +
                "name='test', " +
                "displayName='test displayName', " +
                "password='test', " +
                "description='null', " +
                "email='test@test', " +
                "site='null', " +
                "roles=null}", user.toString());
    }

}
