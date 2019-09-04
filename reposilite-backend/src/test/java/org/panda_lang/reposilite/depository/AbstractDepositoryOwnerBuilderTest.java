/*
 * Copyright (c) 2018-2019 Reposilite Team
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.panda_lang.reposilite.depository;

import org.bson.types.ObjectId;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.panda_lang.reposilite.utils.Buildable;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
class AbstractDepositoryOwnerBuilderTest {

    private TestDepositoryOwner depositoryOwner;

    @BeforeEach
    void setUp() {
        this.depositoryOwner = new TestDepositoryOwnerBuilder()
                .withName("test")
                .withDescription("test description")
                .withDisplayName("test displayName")
                .withEmail("test@test")
                .withSite("www.test.com")
                .build();
    }

    @Test
    void shouldNotBeNull() {
        assertAll(
                () -> assertNotNull(this.depositoryOwner.getName()),
                () -> assertNotNull(this.depositoryOwner.getDescription()),
                () -> assertNotNull(this.depositoryOwner.getDisplayName()),
                () -> assertNotNull(this.depositoryOwner.getEmail()),
                () -> assertNotNull(this.depositoryOwner.getSite())
        );
    }

    @Test
    void toStringTest() {
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

        private final String name;
        private final String displayName;
        private final String description;
        private final String email;
        private final String avatar;
        private final String site;

        TestDepositoryOwner(TestDepositoryOwnerBuilder builder) {
            this.name = builder.name;
            this.displayName = builder.displayName;
            this.description = builder.description;
            this.email = builder.email;
            this.avatar = builder.avatar;
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
        public void setAvatar(String avatar) {

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
        public String getAvatar() {
            return avatar;
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
