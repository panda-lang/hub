package net.dzikoysk.reposilite.domain.depository;

import net.dzikoysk.reposilite.domain.depository.entities.Group;
import org.springframework.lang.Nullable;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class Depository {

    private final File root;
    private final Map<String, Group> groups;

    Depository(File root) {
        this.root = root;
        this.groups = new HashMap<>();
    }

    public void addGroup(Group group) {
        groups.put(group.getName(), group);
    }

    public @Nullable Group getGroup(String groupName) {
        return groups.get(groupName);
    }

    public Map<? extends String, ? extends Group> getGroups() {
        return groups;
    }

    public String getName() {
        return root.getName();
    }

    public File getRootFile() {
        return root;
    }

}
