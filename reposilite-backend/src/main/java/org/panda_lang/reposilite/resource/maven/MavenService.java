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

import org.panda_lang.reposilite.resource.ResourcesSubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.Optional;

@Service
class MavenService implements ResourcesSubService<MavenResource> {

    private final File mavenResourcesDirectory;
    private final MavenRepository mavenRepository;

    @Autowired
    MavenService(@Qualifier("resourcesDirectory") File resourcesDirectory, MavenRepository mavenRepository) {
        this.mavenResourcesDirectory = new File(resourcesDirectory, getName());
        this.mavenRepository = mavenRepository;
    }

    @Override
    public Optional<MavenResource> findByName(String name) {
        return mavenRepository.findByName(name);
    }

    @Override
    public MavenResource save(MavenResource resource) {
        return mavenRepository.save(resource);
    }

    public Optional<MavenResource> findByQulifier(String qualifier) {
        return mavenRepository.findById(qualifier);
    }

    @Override
    public File getServiceDirectory() {
        return mavenResourcesDirectory;
    }

    @Override
    public String getName() {
        return "maven";
    }

}
