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

import org.panda_lang.reposilite.ReposiliteApplication;
import org.panda_lang.reposilite.resource.AbstractResourcesRepository;
import org.panda_lang.reposilite.resource.utils.ResourcesPathMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.io.File;

@Repository
class MavenRepository extends AbstractResourcesRepository<RepositoryResource> {

    private static final String PATTERN = "{repository}/{*group}/{artifact}/{version}/{build}";

    @Autowired
    public MavenRepository(@Qualifier("repositoriesDirectory") File repositoriesRoot) {
        super(new File(repositoriesRoot, "maven"));
    }

    @Override
    public ResourcesPathMapper initializeMapper() {
        ReposiliteApplication.getLogger().info("Loading maven repositories from " + super.getRepositoryRoot() + "...");

        return new ResourcesPathMapper(PATTERN)
                .registerExtensions("jar", "xml", "pom")
                .registerMapper("{repository}", (file, parent, name) -> new RepositoryResource(super.getRepositoryRoot(), name))
                .registerMapper("{group}", (file, parent, name) -> new GroupResource(parent.getFile(), name))
                .registerMapper("{artifact}", (file, parent, name) -> new ArtifactResource(parent.getFile(), name))
                .registerMapper("{version}", (file, parent, name) -> new BuildResource(parent.getFile(), name))
                .registerMapper("{build}", (file, parent, name) -> new DataResource(file));
    }

    @Override
    public void onLoad() {
        ReposiliteApplication.getLogger().info(getEntities().size() + " maven repositories have been found");
    }

}
