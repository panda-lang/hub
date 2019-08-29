package org.panda_lang.reposilite.depository.maven;

import org.panda_lang.reposilite.depository.DepositorySubService;

import java.nio.file.Path;
import java.util.Optional;
import java.util.Set;

public interface MavenService extends DepositorySubService {

    MetadataFile generateMetaDataFile(Depository depository, Group group, Artifact artifact, Path buildDirectoryPath);

    Optional<Depository> getDepository(String name);

    Set<String> getNames();

}
