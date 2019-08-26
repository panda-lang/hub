package org.panda_lang.reposilite.depository.maven;

import org.panda_lang.reposilite.depository.DepositoryEntity;
import org.panda_lang.reposilite.depository.maven.artifact.Artifact;
import org.panda_lang.reposilite.depository.maven.group.Group;
import org.panda_lang.reposilite.utils.FilesUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
class MavenDepositoryServiceImpl implements MavenDepositoryService {

    private final MavenDepositoryRepository mavenDepositoryRepository;

    @Autowired
    public MavenDepositoryServiceImpl(MavenDepositoryRepository mavenDepositoryRepository) {
        this.mavenDepositoryRepository = mavenDepositoryRepository;
    }

    @Override
    public void generateMetaDataFile(MavenDepository mavenDepository, Group group, Artifact artifact, Path buildDirectoryPath) {
        File mostRecentDirectory = FilesUtils.getMostRecentDirectory(buildDirectoryPath.toAbsolutePath());

        MavenMetadataFile metadata = new MavenMetadataFileBuilder()
                .withGroupId(group.getName())
                .withArtifactId(artifact.getName())
                .withLatest(mostRecentDirectory.getName())
                .withLastUpdated(mostRecentDirectory.lastModified())
                .withVersions(new HashSet<>(artifact.getVersions()))
                .withRelease(mostRecentDirectory.getName())
                .build();

        try {
            String metadataFilePath = buildDirectoryPath.toString() + File.separator + "maven-metadata.xml";

            JAXBContext jaxbContext = JAXBContext.newInstance(MavenMetadataFile.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            jaxbMarshaller.marshal(metadata, new File(metadataFilePath));

            FilesUtils.writeFileChecksums(Paths.get(metadataFilePath).toAbsolutePath());
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    @Override
    public @Nullable MavenDepository getDepository(String name) {
        return this.mavenDepositoryRepository.findDepositoryByName(name);
    }

    @Override
    public @Nullable DepositoryEntity getDepositoryEntity(String entityQualifier) {
        return this.mavenDepositoryRepository.findEntityByURLPath(entityQualifier);
    }

    @Override
    public Set<String> getNames() {
        return this.mavenDepositoryRepository.findAll().stream()
                .map(MavenDepository::getName)
                .collect(Collectors.toSet());
    }

    @Override
    public Optional<DepositoryEntity> getEntity(String entityQualifier) {
        return Optional.ofNullable(getDepositoryEntity(entityQualifier));
    }

    @Override
    public Set<? extends DepositoryEntity> getEntities() {
        return mavenDepositoryRepository.findAll();
    }

    @Override
    public String getName() {
        return "Maven";
    }

}
