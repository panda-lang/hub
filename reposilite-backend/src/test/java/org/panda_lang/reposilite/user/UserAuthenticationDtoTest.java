package org.panda_lang.reposilite.user;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
class UserAuthenticationDtoTest {

    @Test
    void toEntityTest() {
        User user = new UserAuthenticationDto("test", "test123").toEntity();

        assertAll(
                () -> assertEquals("test", user.getName()),
                () -> assertEquals("test123", user.getPassword())
        );
    }

}
