package org.panda_lang.reposilite.organization;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.panda_lang.reposilite.user.User;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@RunWith(SpringRunner.class)
class OrganizationBuilderTest {

    private Organization organization;

    @BeforeEach
    void setUp() {
        this.organization = new OrganizationBuilder()
                .withOwner(User.builder()
                        .withPassword("test123")
                        .build())
                .build();
    }

    @Test
    void shouldNotBeNull() {
        assertNotNull(this.organization.getOwner());
    }

    @Test
    void toStringTest() {
        assertEquals("Organization{" +
                "identifier=null, " +
                "name='null', " +
                "displayName='null', " +
                "description='null', " +
                "email='null', " +
                "site='null', " +
                "owner=User{" +
                "identifier=null, " +
                "name='null', " +
                "displayName='null', " +
                "password='test123', " +
                "description='null', " +
                "email='null', " +
                "site='null', " +
                "roles=null}}", this.organization.toString());
    }

}
