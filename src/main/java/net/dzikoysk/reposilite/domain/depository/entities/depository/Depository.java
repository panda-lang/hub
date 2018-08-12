package net.dzikoysk.reposilite.domain.depository.entities.depository;

import net.dzikoysk.reposilite.domain.depository.DepositoryEntity;
import net.dzikoysk.reposilite.domain.depository.entities.AbstractDepositoryEntity;
import net.dzikoysk.reposilite.domain.depository.entities.group.Group;
import net.dzikoysk.reposilite.utils.collection.TreeMapNode;
import org.springframework.lang.Nullable;

import java.io.File;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Depository extends AbstractDepositoryEntity {

    private final File root;
    private final Map<String, Group> groups;

    Depository(File root) {
        this.root = root;
        this.groups = new HashMap<>();
    }

    public TreeMapNode<DepositoryEntity> toTreeMapNode() {
        return new TreeMapNode<>(this);
    }

    public void addGroup(Group group) {
        groups.put(group.getName(), group);
    }

    public @Nullable Group getGroup(String groupName) {
        return groups.get(groupName);
    }

    public Collection<? extends Group> getGroups() {
        return groups.values();
    }

    public File getRootFile() {
        return root;
    }

    @Override
    public String getName() {
        return root.getName();
    }

}
