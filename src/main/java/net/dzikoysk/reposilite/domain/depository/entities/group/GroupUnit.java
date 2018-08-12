package net.dzikoysk.reposilite.domain.depository.entities.group;

import net.dzikoysk.reposilite.domain.depository.DepositoryEntity;

public class GroupUnit implements DepositoryEntity {

    private final String name;

    public GroupUnit(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

}
