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

import org.panda_lang.reposilite.depository.AbstractDepositoryEntity;
import org.panda_lang.utilities.commons.StringUtils;
import org.springframework.lang.Nullable;

import java.io.File;
import java.util.Optional;

final class RepositoryEntity extends AbstractDepositoryEntity {

    public RepositoryEntity(File root, String name) {
        super(root, name);
    }

    protected GroupEntity createIfAbsent(String groupName) {
        String[] units = StringUtils.split(groupName, ".");
        GroupEntity previousGroup = createIfAbsent(this, units[0]);

        for (int index = 1; index < units.length && previousGroup != null; index++) {
            previousGroup = createIfAbsent(previousGroup, units[index]);
        }

        return previousGroup;
    }

    private @Nullable
    GroupEntity createIfAbsent(org.panda_lang.reposilite.depository.DepositoryEntity parent, String name) {
        Optional<org.panda_lang.reposilite.depository.DepositoryEntity> entityValue = parent.find(name);

        if (!entityValue.isPresent()) {
            GroupEntity group = new GroupEntity(parent.getFile(), name);
            parent.addEntity(group);
            return group;
        }

        org.panda_lang.reposilite.depository.DepositoryEntity entity = entityValue.get();

        if (entity instanceof GroupEntity) {
            return (GroupEntity) entity;
        }

        return null;
    }

    public @Nullable
    GroupEntity getGroup(String groupName) {
        return super.getMappedChildrenOfType(GroupEntity.class).get(groupName);
    }

}
