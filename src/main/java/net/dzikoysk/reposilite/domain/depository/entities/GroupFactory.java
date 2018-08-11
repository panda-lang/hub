package net.dzikoysk.reposilite.domain.depository.entities;

import net.dzikoysk.reposilite.domain.depository.Depository;

public class GroupFactory {

    private final Depository depository;

    public GroupFactory(Depository depository) {
        this.depository = depository;
    }

    public Group obtainGroup(String groupName) {
        return depository.getGroup(groupName) != null?  depository.getGroup(groupName) : new Group(groupName);
    }

}
