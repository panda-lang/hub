package org.panda_lang.reposilite.depository.maven;

import org.panda_lang.reposilite.depository.AbstractDepositoryEntity;
import org.springframework.lang.Nullable;

import java.io.File;
import java.util.Collection;

public final class Depository extends AbstractDepositoryEntity {

    private final File root;

    Depository(File root) {
        super(root.getName());
        this.root = root;
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
