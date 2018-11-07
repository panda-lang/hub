package org.panda_lang.reposilite.depository;

import org.panda_lang.reposilite.depository.group.Group;
import org.panda_lang.reposilite.depository.group.GroupUnit;
import org.springframework.lang.Nullable;

import java.io.File;
import java.util.Collection;

public class Depository extends AbstractDepositoryEntity {

    private final File root;

    Depository(File root) {
        super(root.getName());
        this.root = root;
    }

    public @Nullable
    GroupUnit findGroupUnit(String partOfGroupName) {
        for (Group group : getGroups()) {
            GroupUnit unit = group.matchGroupUnit(partOfGroupName);

            if (unit != null) {
                return unit;
            }
        }

        return null;
    }

    public void addGroup(Group group) {
        super.addElement(group);
    }

    public @Nullable Group getGroup(String groupName) {
        return super.getMappedChildrenOfType(Group.class).get(groupName);
    }

    public Collection<? extends Group> getGroups() {
        return super.getChildrenOfType(Group.class);
    }

    public File getRootFile() {
        return root;
    }

}
