package org.panda_lang.reposilite.depository.maven;

import org.panda_lang.reposilite.depository.AbstractDepositoryEntity;
import org.panda_lang.reposilite.depository.maven.group.Group;
import org.panda_lang.reposilite.depository.maven.group.GroupUnit;
import org.springframework.lang.Nullable;

import java.io.File;
import java.util.Collection;

public class MavenDepository extends AbstractDepositoryEntity {

    private final File root;

    MavenDepository(File root) {
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
