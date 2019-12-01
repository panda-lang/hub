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

package org.panda_lang.reposilite.project;

import org.junit.jupiter.api.Test;
import org.panda_lang.reposilite.user.Owner;
import org.panda_lang.reposilite.user.User;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ProjectUpdateDtoTest {

    @Test
    void toEntityTest() {
        Owner owner = User.builder().withName("user").build();
        Project project = new ProjectUpdateDto("project", owner, "github:https://github.com/panda-lang/panda", "panda-lang.org").toEntity();

        assertEquals("Project{" +
                "identifier=null, " +
                "name='project', " +
                "owner=" + owner.toString() + ", " +
                "platformUri='github:https://github.com/panda-lang/panda', " +
                "website='panda-lang.org'" +
                "}", project.toString());
    }

}