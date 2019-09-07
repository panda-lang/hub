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

import org.panda_lang.reposilite.depository.DepositorySubService;

import java.nio.file.Path;
import java.util.Optional;
import java.util.Set;

public interface MavenService extends DepositorySubService {

    MetadataFile generateMetaDataFile(Depository depository, Group group, Artifact artifact, Path buildDirectoryPath);

    Optional<Depository> getDepository(String name);

    Set<String> getNames();

    @Override
    default String getName() {
        return "maven";
    }

}
