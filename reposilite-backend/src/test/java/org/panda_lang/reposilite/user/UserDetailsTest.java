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

package org.panda_lang.reposilite.user;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.panda_lang.panda.utilities.commons.StringUtils;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class UserDetailsTest {

    private static User user;
    private static Map<String, Object> attributes = new HashMap<>();
    private static UserDetails details;

    @BeforeAll
    static void prepare() {
        user = User.builder()
                .withName("username")
                .withPassword(StringUtils.EMPTY)
                .build();

        details = UserDetails.of(user, attributes);
        assertNotNull(details);
    }

    @Test
    void getAttributes() {
        assertEquals(attributes, details.getAttributes());
    }

    @Test
    void getUser() {
        assertEquals(user, details.getUser());
    }

}