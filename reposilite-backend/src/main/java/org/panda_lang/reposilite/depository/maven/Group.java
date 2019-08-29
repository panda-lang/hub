package org.panda_lang.reposilite.depository.maven;

import org.panda_lang.reposilite.depository.AbstractDepositoryEntity;
import org.springframework.lang.Nullable;

import java.util.Collection;

public class Group extends AbstractDepositoryEntity {

    Group(String name) {
        super(name);
    }

    public @Nullable Artifact getArtifact(String artifactName) {
        return super.getMappedChildrenOfType(Artifact.class).get(artifactName);
    }

    public Collection<? extends Artifact> getArtifacts() {
        return super.getChildrenOfType(Artifact.class);
    }

}
