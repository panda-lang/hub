package org.panda_lang.reposilite.user;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.panda_lang.panda.utilities.commons.collection.Sets;
import org.panda_lang.reposilite.user.role.Role;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
class UserBuilderTest {

    private User user;

    @BeforeEach
    void setUp() throws Exception {
        this.user = new UserBuilder()
                .withPassword("test123")
                .withRoles(Sets.newHashSet(new Role("USER")))
                .build();
    }

    @Test
    void shouldNotBeNull() {
        assertAll(
                () -> assertNotNull(this.user.getPassword()),
                () -> assertNotNull(this.user.getRoles())
        );
    }

    @Test
    void toStringTest() {
        assertEquals("User{" +
                "identifier=null, " +
                "name='null', " +
                "displayName='null', " +
                "password='test123', " +
                "description='null', " +
                "email='null', " +
                "site='null', " +
                "roles=[Role{name='USER'}]}", this.user.toString());
    }

}
