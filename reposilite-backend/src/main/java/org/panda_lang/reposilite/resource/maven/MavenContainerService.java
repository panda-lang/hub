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

package org.panda_lang.reposilite.resource.maven;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.Optional;

@Service
final class MavenContainerService {

    private final MavenContainerRepository groupRepository;

    @Autowired
    MavenContainerService(MavenContainerRepository groupRepository) {
        this.groupRepository = groupRepository;
    }

    MavenResource save(MavenResource group) {
        return groupRepository.save(group);
    }

    Optional<MavenResource> findById(String name) {
        return groupRepository.findById(name);
    }

    MavenResource create(File root, String groupQualifier, MavenResourceType type) {
        String[] groups = groupQualifier.split(":");

        MavenResource parentGroup = null;
        int index = 0;

        do {
            String name = groups[index++];
            parentGroup = findOrCreate(root, parentGroup, type, name);
        } while (index < groups.length);

        return parentGroup;
    }

    private MavenResource findOrCreate(File root, @Nullable MavenResource parentGroup, MavenResourceType type, String name) {
        return findById(name).orElseGet(() -> {
            return save(new MavenResource(name, parentGroup != null ? new File(parentGroup.getFile(), name) : root, type, parentGroup));
        });
    }

}
