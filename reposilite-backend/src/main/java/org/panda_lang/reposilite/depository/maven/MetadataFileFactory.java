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

import org.panda_lang.reposilite.utils.FilesUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;

public class MetadataFileFactory {

    private final MavenService mavenService;

    public MetadataFileFactory(MavenService mavenService) {
        this.mavenService = mavenService;
    }

    public MetadataFile createMetadataFile(Depository depository, MavenMetadata metadata, MavenMetadataPaths paths, MultipartFile file) throws IOException {
        Group group = depository.createIfAbsent(metadata.getGroupName());
        Artifact artifact = group.createIfAbsent(metadata.getArtifactName(), Artifact::new);
        artifact.createIfAbsent(metadata.getBuildVersion(), Build::new);

        Files.createDirectories(paths.getBuildDirectory());
        FilesUtils.storeFile(paths.getBuildDirectory(), file, false);
        FilesUtils.writeFileChecksums(paths.getBuildFile().toAbsolutePath());

        return mavenService.generateMetaDataFile(depository, group, artifact, paths.getBuildDirectory().getParent());
    }

}
