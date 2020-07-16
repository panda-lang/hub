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

package org.panda_lang.hub.user;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
class UserRegistrationDtoTest {

    @Test
    void toEntityTest() {
        User user = new UserRegistrationDto("test", "test displayName", "test", "test", "test@test", "test@test").toEntity();

        assertEquals("User{" +
                "identifier=null, " +
                "name='test', " +
                "displayName='test displayName', " +
                "password='test', " +
                "description='null', " +
                "email='test@test', " +
                "site='null', " +
                "roles=[]}", user.toString());
    }

}
