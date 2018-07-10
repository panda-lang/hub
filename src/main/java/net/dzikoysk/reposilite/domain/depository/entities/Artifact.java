package net.dzikoysk.reposilite.domain.depository.entities;

import net.dzikoysk.reposilite.domain.depository.DepositoryEntity;

import java.util.Collection;

public class Artifact implements DepositoryEntity {

    private String name;
    private Collection<Build> builds;

    public synchronized void updateLocalMetadata() {

    }

}
