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

package org.panda_lang.reposilite.depository.maven;

import org.jetbrains.annotations.Nullable;
import org.panda_lang.panda.utilities.commons.StringUtils;
import org.panda_lang.reposilite.depository.DepositoryEntity;

import java.util.Optional;

class GroupFactory {

    private final Depository depository;

    GroupFactory(Depository depository) {
        this.depository = depository;
    }

    protected Group obtainGroup(String groupName) {
        String[] units = StringUtils.split(groupName, ".");
        Group previousGroup = obtainGroup(depository, units[0]);

        for (int index = 1; index < units.length && previousGroup != null; index++) {
            previousGroup = obtainGroup(previousGroup, units[index]);
        }

        return previousGroup;
    }

    private @Nullable Group obtainGroup(DepositoryEntity parent, String name) {
        Optional<DepositoryEntity> entityValue = parent.find(name);

        if (!entityValue.isPresent()) {
            Group group = new Group(name);
            parent.addEntity(group);
            return group;
        }

        DepositoryEntity entity = entityValue.get();

        if (entity instanceof Group) {
            return (Group) entity;
        }

        return null;
    }

}
