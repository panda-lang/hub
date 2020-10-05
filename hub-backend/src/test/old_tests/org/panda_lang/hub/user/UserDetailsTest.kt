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

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.panda_lang.utilities.commons.StringUtils
import java.util.HashMap
import java.util.Map

internal class UserDetailsTest {
    @get:Test
    val attributes: Unit
        get() {
            assertEquals(Companion.attributes, details.getAttributes())
        }

    @get:Test
    val user: Unit
        get() {
            assertEquals(Companion.user, details.getUser())
        }

    companion object {
        private var user: User? = null
        private val attributes: Map<String, Object> = HashMap()
        private var details: UserDetails? = null
        @BeforeAll
        fun prepare() {
            user = User.builder()
                .withName("username")
                .withPassword(StringUtils.EMPTY)
                .build()
            details = UserDetails.of(user, attributes)
            assertNotNull(details)
        }
    }
}
