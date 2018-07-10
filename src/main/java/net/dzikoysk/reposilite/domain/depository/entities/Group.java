package net.dzikoysk.reposilite.domain.depository.entities;

import net.dzikoysk.reposilite.domain.depository.DepositoryEntity;

import java.util.Collection;

public class Group implements DepositoryEntity {

    private Collection<Artifact> artifacts;

}
