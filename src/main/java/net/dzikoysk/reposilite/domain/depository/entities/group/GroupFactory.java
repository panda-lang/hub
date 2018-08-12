package net.dzikoysk.reposilite.domain.depository.entities.group;

import net.dzikoysk.reposilite.domain.depository.entities.depository.Depository;

public class GroupFactory {

    private final Depository depository;

    public GroupFactory(Depository depository) {
        this.depository = depository;
    }

    public Group obtainGroup(String groupName) {
        Group group = depository.getGroup(groupName);

        if (group == null) {
            group = new Group(createGroupUnits(groupName));
        }

        return group;
    }

    private GroupUnit[] createGroupUnits(String groupName) {
        String[] elements = groupName.split("\\.");
        GroupUnit[] units = new GroupUnit[elements.length];

        for (int i = 0; i < elements.length; i++) {
            units[i] = new GroupUnit(elements[i]);
        }

        return units;
    }

}
