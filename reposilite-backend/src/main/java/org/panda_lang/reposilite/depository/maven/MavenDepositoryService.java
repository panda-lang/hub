package org.panda_lang.reposilite.depository.maven;

import org.panda_lang.reposilite.depository.DepositoryEntity;
import org.panda_lang.reposilite.depository.DepositorySubService;
import org.panda_lang.reposilite.depository.maven.artifact.Artifact;
import org.panda_lang.reposilite.depository.maven.group.Group;
import org.springframework.lang.Nullable;

import java.nio.file.Path;
import java.util.Set;

public interface MavenDepositoryService extends DepositorySubService {

    @Nullable MavenDepository getDepository(String name);

    @Nullable DepositoryEntity getDepositoryEntity(String entityQualifier);

    void generateMetaDataFile(MavenDepository mavenDepository, Group group, Artifact artifact, Path buildDirectoryPath);

    Set<String> getNames();

}
