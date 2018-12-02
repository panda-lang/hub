package org.panda_lang.reposilite.depository;

import org.panda_lang.reposilite.depository.artifact.Artifact;
import org.panda_lang.reposilite.depository.group.Group;
import org.panda_lang.reposilite.utils.FilesUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.nio.file.Path;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class DepositoryServiceImpl implements DepositoryService {

    private final DepositoryRepository depositoryRepository;

    @Autowired
    public DepositoryServiceImpl(DepositoryRepository depositoryRepository) {
        this.depositoryRepository = depositoryRepository;
    }

    @Override
    public @Nullable Depository getDepository(String name) {
        return depositoryRepository.findDepositoryByName(name);
    }

    @Override
    public @Nullable DepositoryEntity getDepositoryEntity(Depository depository, String entityQualifier) {
        return depositoryRepository.findEntityByURLPath(depository, entityQualifier);
    }

    @Override
    public void generateMetaDataFile(Depository depository, Group group, Artifact artifact, Path buildDirectoryPath) {
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
            JAXBContext jaxbContext = JAXBContext.newInstance(MavenMetadataFile.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            jaxbMarshaller.marshal(metadata, new File(buildDirectoryPath.toString() + File.separator + "maven-metadata.xml"));
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Set<String> getNames() {
        return depositoryRepository.findAll().stream()
                .map(Depository::getName)
                .collect(Collectors.toSet());
    }

}
