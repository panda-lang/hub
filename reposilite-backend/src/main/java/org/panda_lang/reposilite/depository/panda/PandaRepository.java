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

import org.panda_lang.reposilite.ReposiliteApplication;
import org.panda_lang.reposilite.depository.AbstractDepositoryRepository;
import org.panda_lang.reposilite.depository.utils.DepositoryPathMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.io.File;

@Repository
class PandaRepository extends AbstractDepositoryRepository<OwnerEntity> {

    private static final String PATTERN = "{owner}/{project}/builds/{build}";

    @Autowired
    PandaRepository(@Qualifier("repositoriesDirectory") File packagesRoot) {
        super(new File(packagesRoot, "panda"));
    }

    @Override
    public DepositoryPathMapper initializeMapper() {
        ReposiliteApplication.getLogger().info("Loading Panda packages from " + super.getRepositoryRoot() + "...");

        return new DepositoryPathMapper(PATTERN)
                .registerExtensions("zip", "proxy")
                .registerMapper("{owner}", (file, parent, name) -> new OwnerEntity(name))
                .registerMapper("{project}", (file, parent, name) -> new ProjectEntity(name))
                .registerMapper("{build}", (file, parent, name) -> new BuildEntity(file));
    }

    @Override
    public void onLoad() {
        long sum = getEntities().values().stream()
                .mapToLong(entity -> entity.getChildren().size())
                .sum();

        ReposiliteApplication.getLogger().info(sum + " panda packages have been found");
    }

}
