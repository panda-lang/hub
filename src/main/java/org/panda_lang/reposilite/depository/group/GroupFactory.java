package org.panda_lang.reposilite.depository.group;

import org.panda_lang.reposilite.depository.Depository;
import org.panda_lang.panda.utilities.commons.StringUtils;

public class GroupFactory {

    private final Depository depository;

    public GroupFactory(Depository depository) {
        this.depository = depository;
    }

    public Group obtainGroup(String groupName) {
        if (StringUtils.isEmpty(groupName)) {
            return null;
        }

        Group group = depository.getGroup(groupName);

        if (group == null) {
            group = new Group(createGroupUnits(groupName));
            depository.addGroup(group);
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
