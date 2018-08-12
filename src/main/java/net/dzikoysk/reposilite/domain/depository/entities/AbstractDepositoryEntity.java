package net.dzikoysk.reposilite.domain.depository.entities;

import net.dzikoysk.reposilite.domain.depository.DepositoryEntity;

public abstract class AbstractDepositoryEntity implements DepositoryEntity {

    @Override
    public String toString() {
        return getName();
    }

}
