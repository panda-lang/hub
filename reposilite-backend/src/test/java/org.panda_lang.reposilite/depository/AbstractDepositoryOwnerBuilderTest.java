package org.panda_lang.reposilite.depository;

import org.bson.types.ObjectId;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.panda_lang.reposilite.utils.Buildable;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
public class AbstractDepositoryOwnerBuilderTest {

    private TestDepositoryOwner depositoryOwner;

    @Before
    public void setUp() throws Exception {
        this.depositoryOwner = new TestDepositoryOwnerBuilder()
                .withName("test")
                .withDescription("test description")
                .withDisplayName("test displayName")
                .withEmail("test@test")
                .withSite("www.test.com")
                .build();
    }

    @Test
    public void shouldNotBeNull() {
        assertAll(
                () -> assertNotNull(this.depositoryOwner.getName()),
                () -> assertNotNull(this.depositoryOwner.getDescription()),
                () -> assertNotNull(this.depositoryOwner.getDisplayName()),
                () -> assertNotNull(this.depositoryOwner.getEmail()),
                () -> assertNotNull(this.depositoryOwner.getSite())
        );
    }

    @Test
    public void toStringTest() {
        assertEquals("TestDepositoryOwner{" +
                "name='test', " +
                "displayName='test displayName', " +
                "description='test description', " +
                "email='test@test', " +
                "site='www.test.com'}", this.depositoryOwner.toString());
    }

    private static class TestDepositoryOwnerBuilder extends AbstractDepositoryOwnerBuilder<TestDepositoryOwnerBuilder> implements Buildable<TestDepositoryOwner> {

        @Override
        public TestDepositoryOwner build() {
            return new TestDepositoryOwner(this);
        }

    }

    private static class TestDepositoryOwner implements DepositoryOwner {

        private String name;
        private String displayName;
        private String description;
        private String email;
        private String site;

        public TestDepositoryOwner(TestDepositoryOwnerBuilder builder) {
            this.name = builder.name;
            this.displayName = builder.displayName;
            this.description = builder.description;
            this.email = builder.email;
            this.site = builder.site;
        }

        @Override
        public void setName(String name) {

        }

        @Override
        public void setDisplayName(String displayName) {

        }

        @Override
        public void setDescription(String description) {

        }

        @Override
        public void setEmail(String email) {

        }

        @Override
        public void setSite(String site) {

        }

        @Override
        public String getName() {
            return this.name;
        }

        @Override
        public String getDisplayName() {
            return this.displayName;
        }

        @Override
        public String getDescription() {
            return this.description;
        }

        @Override
        public String getEmail() {
            return this.email;
        }

        @Override
        public String getSite() {
            return this.site;
        }

        @Override
        public ObjectId getIdentifier() {
            return null;
        }

        @Override
        public String toString() {
            return "TestDepositoryOwner{" +
                    "name='" + this.name + '\'' +
                    ", displayName='" + this.displayName + '\'' +
                    ", description='" + this.description + '\'' +
                    ", email='" + this.email + '\'' +
                    ", site='" + this.site + '\'' +
                    '}';
        }

    }

}
