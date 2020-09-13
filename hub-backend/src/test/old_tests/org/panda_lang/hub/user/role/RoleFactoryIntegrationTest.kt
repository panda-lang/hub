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
package org.panda_lang.hub.user.role

import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.test.context.junit4.SpringRunner
import org.junit.jupiter.api.Assertions.*
import kotlin.Throws

@RunWith(SpringRunner::class)
@SpringBootTest
internal class RoleFactoryIntegrationTest {
    @Autowired
    private val roleFactory: RoleFactory? = null

    @Autowired
    private val mongoTemplate: MongoTemplate? = null
    @Test
    fun obtainNewRoleTest() {
        val role: Role = roleFactory.obtainRole("SUPER_VIP")
        assertAll(
                { assertNotNull(role) }
        ) { assertNotNull(mongoTemplate.findById("SUPER_VIP", Role::class.java)) }
    }

    @AfterEach
    fun tearDown() {
        mongoTemplate.dropCollection("roles")
    }
}