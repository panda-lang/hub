/*
 * Copyright (c) 2020 Hub Team of panda-lang organization
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
package org.panda_lang.hub.user

import org.bson.types.ObjectId
import org.junit.jupiter.api.Assertions.assertAll
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.runner.RunWith
import org.panda_lang.hub.utils.Buildable
import org.springframework.test.context.junit4.SpringRunner

@RunWith(SpringRunner::class)
internal class AbstractOwnerBuilderTest {
    private var projectOwner: TestOwner? = null
    @BeforeEach
    fun setUp() {
        projectOwner = TestProjectOwnerBuilder()
            .withName("test")
            .withDescription("test description")
            .withDisplayName("test displayName")
            .withEmail("test@test")
            .withSite("www.test.com")
            .build()
    }

    @Test
    fun shouldNotBeNull() {
        assertAll(
            { assertNotNull(projectOwner!!.getName()) },
            { assertNotNull(projectOwner!!.getDescription()) },
            { assertNotNull(projectOwner!!.getDisplayName()) },
            { assertNotNull(projectOwner!!.getEmail()) }
        ) { assertNotNull(projectOwner!!.getSite()) }
    }

    @Test
    fun toStringTest() {
        assertEquals(
            "TestProjectOwner{" +
                "name='test', " +
                "displayName='test displayName', " +
                "description='test description', " +
                "email='test@test', " +
                "site='www.test.com'}",
            projectOwner.toString()
        )
    }

    private class TestProjectOwnerBuilder : Owner.AbstractProjectOwnerBuilder<TestProjectOwnerBuilder?>(), Buildable<TestOwner?> {
        @Override
        fun build(): TestOwner {
            return TestOwner(this)
        }
    }

    private class TestOwner internal constructor(builder: TestProjectOwnerBuilder) : Owner {
        private val name: String
        private val displayName: String
        private val description: String
        private val email: String
        private val avatar: String
        private val site: String
        @Override
        fun setName(name: String?) {
        }

        @Override
        fun setDisplayName(displayName: String?) {
        }

        @Override
        fun setDescription(description: String?) {
        }

        @Override
        fun setEmail(email: String?) {
        }

        @Override
        fun setAvatar(avatar: String?) {
        }

        @Override
        fun setSite(site: String?) {
        }

        @Override
        fun getName(): String {
            return name
        }

        @Override
        fun getDisplayName(): String {
            return displayName
        }

        @Override
        fun getDescription(): String {
            return description
        }

        @Override
        fun getEmail(): String {
            return email
        }

        @Override
        fun getAvatar(): String {
            return avatar
        }

        @Override
        fun getSite(): String {
            return site
        }

        @get:Override
        val identifier: ObjectId?
            get() = null

        @Override
        override fun toString(): String {
            return "TestProjectOwner{" +
                "name='" + name + '\'' +
                ", displayName='" + displayName + '\'' +
                ", description='" + description + '\'' +
                ", email='" + email + '\'' +
                ", site='" + site + '\'' +
                '}'
        }

        init {
            name = builder.name
            displayName = builder.displayName
            description = builder.description
            email = builder.email
            avatar = builder.avatar
            site = builder.site
        }
    }
}
