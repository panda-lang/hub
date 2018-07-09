package net.dzikoysk.reposilite.service.depository;

import net.dzikoysk.reposilite.domain.depository.DepositoryEntity;
import net.dzikoysk.reposilite.repository.depository.ArtifactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;

@Service
public class ArtifactService {

    private final ArtifactRepository artifactRepository;

    public ArtifactService(@Autowired ArtifactRepository artifactRepository) {
        this.artifactRepository = artifactRepository;
    }

    public @Nullable DepositoryEntity getDepositoryEntity(String entityQualifier) {
        return null;
    }

}
