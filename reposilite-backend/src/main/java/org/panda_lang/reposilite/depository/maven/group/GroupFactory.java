package org.panda_lang.reposilite.depository.maven.group;

import org.panda_lang.reposilite.depository.maven.MavenDepository;
import org.panda_lang.panda.utilities.commons.StringUtils;

public class GroupFactory {

    private final MavenDepository mavenDepository;

    public GroupFactory(MavenDepository mavenDepository) {
        this.mavenDepository = mavenDepository;
    }

    public Group obtainGroup(String groupName) {
        if (StringUtils.isEmpty(groupName)) {
            return null;
        }

        Group group = mavenDepository.getGroup(groupName);

        if (group == null) {
            group = new Group(createGroupUnits(groupName));
            mavenDepository.addGroup(group);
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
