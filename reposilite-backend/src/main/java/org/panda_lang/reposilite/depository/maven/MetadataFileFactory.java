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
        GroupFactory groupFactory = new GroupFactory(depository);
        Group group = groupFactory.obtainGroup(metadata.getGroupName());

        ArtifactFactory artifactFactory = new ArtifactFactory(group);
        Artifact artifact = artifactFactory.obtainArtifact(metadata.getArtifactName());

        BuildFactory buildFactory = new BuildFactory(artifact);
        buildFactory.obtainBuild(metadata.getBuildVersion());

        Files.createDirectories(paths.getBuildDirectory());
        FilesUtils.storeFile(paths.getBuildDirectory(), file, false);
        FilesUtils.writeFileChecksums(paths.getBuildFile().toAbsolutePath());

        return mavenService.generateMetaDataFile(depository, group, artifact, paths.getBuildDirectory().getParent());
    }

}
