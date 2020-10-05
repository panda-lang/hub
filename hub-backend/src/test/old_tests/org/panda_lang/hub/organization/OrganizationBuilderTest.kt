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
package org.panda_lang.hub.organization

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.runner.RunWith
import org.panda_lang.hub.user.User
import org.springframework.test.context.junit4.SpringRunner

@RunWith(SpringRunner::class)
internal class OrganizationBuilderTest {
    private var organization: Organization? = null
    @BeforeEach
    fun setUp() {
        organization = OrganizationBuilder()
            .withOwner(
                User.builder()
                    .withPassword("test123")
                    .build()
            )
            .build()
    }

    @Test
    fun shouldNotBeNull() {
        assertNotNull(organization.getOwner())
    }

    @Test
    fun toStringTest() {
        assertEquals(
            "Organization{" +
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
                "roles=[]}}",
            organization.toString()
        )
    }
}
