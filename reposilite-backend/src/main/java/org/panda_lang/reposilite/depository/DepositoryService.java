package org.panda_lang.reposilite.depository;

import org.panda_lang.reposilite.depository.artifact.Artifact;
import org.panda_lang.reposilite.depository.group.Group;
import org.springframework.lang.Nullable;

import java.nio.file.Path;
import java.util.Set;

public interface DepositoryService {

    @Nullable
    Depository getDepository(String name);

    @Nullable
    DepositoryEntity getDepositoryEntity(Depository depository, String entityQualifier);

    void generateMetaDataFile(Depository depository, Group group, Artifact artifact, Path buildDirectoryPath);

    Set<String> getNames();

}
