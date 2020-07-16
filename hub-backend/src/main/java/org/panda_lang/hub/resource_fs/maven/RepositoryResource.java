/*
 * Copyright (c) 2018-2019 Hub Team
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

package org.panda_lang.hub.resource_fs.maven;

import org.panda_lang.hub.resource_fs.AbstractResource;
import org.panda_lang.hub.resource_fs.Resource;
import org.panda_lang.utilities.commons.StringUtils;
import org.springframework.lang.Nullable;

import java.io.File;
import java.util.Optional;

final class RepositoryResource extends AbstractResource {

    public RepositoryResource(File root, String name) {
        super(root, name);
    }

    protected GroupResource createIfAbsent(String groupName) {
        String[] units = StringUtils.split(groupName, ".");
        GroupResource previousGroup = createIfAbsent(this, units[0]);

        for (int index = 1; index < units.length && previousGroup != null; index++) {
            previousGroup = createIfAbsent(previousGroup, units[index]);
        }

        return previousGroup;
    }

    private @Nullable
    GroupResource createIfAbsent(Resource parent, String name) {
        Optional<Resource> entityValue = parent.find(name);

        if (!entityValue.isPresent()) {
            GroupResource group = new GroupResource(parent.getFile(), name);
            parent.addEntity(group);
            return group;
        }

        Resource entity = entityValue.get();

        if (entity instanceof GroupResource) {
            return (GroupResource) entity;
        }

        return null;
    }

    public @Nullable
    GroupResource getGroup(String groupName) {
        return super.getMappedChildrenOfType(GroupResource.class).get(groupName);
    }

}
