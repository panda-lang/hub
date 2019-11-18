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

import org.panda_lang.reposilite.ReposiliteApplication;
import org.panda_lang.reposilite.depository.AbstractDepositoryRepository;
import org.panda_lang.reposilite.depository.utils.DepositoryPathMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.io.File;

@Repository
class MavenRepository extends AbstractDepositoryRepository<RepositoryEntity> {

    private static final String PATTERN = "{repository}/{*group}/{artifact}/{version}/{build}";

    @Autowired
    public MavenRepository(@Qualifier("repositoriesDirectory") File repositoriesRoot) {
        super(new File(repositoriesRoot, "maven"));
    }

    @Override
    public DepositoryPathMapper initializeMapper() {
        ReposiliteApplication.getLogger().info("Loading maven repositories from " + super.getRepositoryRoot() + "...");

        return new DepositoryPathMapper(PATTERN)
                .registerExtensions("jar", "xml", "pom")
                .registerMapper("{repository}", (file, parent, name) -> new RepositoryEntity(super.getRepositoryRoot(), name))
                .registerMapper("{group}", (file, parent, name) -> new GroupEntity(parent.getFile(), name))
                .registerMapper("{artifact}", (file, parent, name) -> new ArtifactEntity(parent.getFile(), name))
                .registerMapper("{version}", (file, parent, name) -> new BuildEntity(parent.getFile(), name))
                .registerMapper("{build}", (file, parent, name) -> new DataEntity(file));
    }

    @Override
    public void onLoad() {
        ReposiliteApplication.getLogger().info(getEntities().size() + " maven repositories have been found");
    }

}
