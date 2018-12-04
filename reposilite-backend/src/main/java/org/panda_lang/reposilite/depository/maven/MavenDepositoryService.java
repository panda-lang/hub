package org.panda_lang.reposilite.depository.maven;

import org.panda_lang.reposilite.depository.DepositoryEntity;
import org.panda_lang.reposilite.depository.maven.artifact.Artifact;
import org.panda_lang.reposilite.depository.maven.group.Group;
import org.springframework.lang.Nullable;

import java.nio.file.Path;
import java.util.Set;

public interface MavenDepositoryService {

    @Nullable
    MavenDepository getDepository(String name);

    @Nullable
    DepositoryEntity getDepositoryEntity(MavenDepository mavenDepository, String entityQualifier);

    void generateMetaDataFile(MavenDepository mavenDepository, Group group, Artifact artifact, Path buildDirectoryPath);

    Set<String> getNames();

}
