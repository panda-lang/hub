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

package org.panda_lang.reposilite.depository.panda;

import org.panda_lang.reposilite.depository.DepositoryEntity;
import org.panda_lang.reposilite.depository.utils.DepositoryPathMapper;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.Map;

@Service
final class PackageFacade {

    private static final String PATTERN = "{owner}/{project}/builds/{build}";

    Map<String, DepositoryEntity> loadPackages(File packagesRoot) {
        DepositoryPathMapper mapper = new DepositoryPathMapper(PATTERN)
                .registerExtensions("zip", "proxy")
                .registerMapper("{owner}", (parent, name) -> new OwnerEntity(name))
                .registerMapper("{project}", (parent, name) -> new ProjectEntity(name))
                .registerMapper("{build}", (parent, name) -> new BuildEntity(name));

        return mapper.map(packagesRoot);
    }

}
