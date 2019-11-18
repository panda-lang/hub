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
import org.panda_lang.reposilite.depository.ProjectDepositoryEntity;
import org.panda_lang.utilities.commons.text.ContentJoiner;

import java.io.File;
import java.util.List;
import java.util.stream.Collectors;

final class ArtifactEntity extends AbstractDepositoryEntity implements ProjectDepositoryEntity {

    ArtifactEntity(File root, String name) {
        super(root, name);
    }

    protected List<? extends String> getVersions() {
        return super.streamOfType(BuildEntity.class)
                .map(BuildEntity::getName)
                .sorted()
                .collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return getName() + " { " + ContentJoiner.on(", ").join(getVersions()) + " }";
    }

}
