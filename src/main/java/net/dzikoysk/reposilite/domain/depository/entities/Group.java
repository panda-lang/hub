package net.dzikoysk.reposilite.domain.depository.entities;

import net.dzikoysk.reposilite.domain.depository.DepositoryEntity;

import java.util.Collection;

public class Group implements DepositoryEntity {

    private final String name;
    private Collection<Artifact> artifacts;

    public Group(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
