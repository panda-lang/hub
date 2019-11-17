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

import org.panda_lang.reposilite.depository.DepositoryEntity;
import org.panda_lang.reposilite.utils.FilesUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
final class MavenServiceImpl implements MavenService {

    private final MavenRepository mavenRepository;

    @Autowired
    MavenServiceImpl(MavenRepository mavenRepository) {
        this.mavenRepository = mavenRepository;
    }

    @Override
    public MetadataFile generateMetaDataFile(Depository depository, Group group, Artifact artifact, Path buildDirectoryPath) {
        File mostRecentDirectory = FilesUtils.getMostRecentDirectory(buildDirectoryPath.toAbsolutePath());

        MetadataFile metadata = new MetadataFileBuilder()
                .withGroupId(group.getName())
                .withArtifactId(artifact.getName())
                .withLatest(mostRecentDirectory.getName())
                .withLastUpdated(mostRecentDirectory.lastModified())
                .withVersions(new HashSet<>(artifact.getVersions()))
                .withRelease(mostRecentDirectory.getName())
                .build();

        try {
            String metadataFilePath = buildDirectoryPath.toString() + File.separator + "maven-metadata.xml";

            JAXBContext jaxbContext = JAXBContext.newInstance(MetadataFile.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            jaxbMarshaller.marshal(metadata, new File(metadataFilePath));

            FilesUtils.writeFileChecksums(Paths.get(metadataFilePath).toAbsolutePath());
        } catch (JAXBException e) {
            e.printStackTrace();
        }

        return metadata;
    }

    @Override
    public Optional<? extends DepositoryEntity> findEntity(String entityQualifier) {
        return this.mavenRepository.findEntityByURLPath(entityQualifier);
    }

    @Override
    public Optional<Depository> getDepository(String name) {
        return this.mavenRepository.findEntityByName(name);
    }

    @Override
    public Set<String> getNames() {
        return this.mavenRepository.findAll().stream()
                .map(Depository::getName)
                .collect(Collectors.toSet());
    }

    @Override
    public Set<? extends DepositoryEntity> getEntities() {
        return mavenRepository.findAll();
    }

}
