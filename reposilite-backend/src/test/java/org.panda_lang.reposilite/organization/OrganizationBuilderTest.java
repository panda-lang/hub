package org.panda_lang.reposilite.organization;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.panda_lang.reposilite.user.UserBuilder;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
public class OrganizationBuilderTest {

    private Organization organization;

    @Before
    public void setUp() throws Exception {
        this.organization = new OrganizationBuilder()
                .withOwner(new UserBuilder()
                        .withPassword("test123")
                        .build())
                .build();
    }

    @Test
    public void shouldNotBeNull() {
        assertNotNull(this.organization.getOwner());
    }

    @Test
    public void toStringTest() {
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
