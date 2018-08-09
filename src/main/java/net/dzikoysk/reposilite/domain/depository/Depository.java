package net.dzikoysk.reposilite.domain.depository;

import net.dzikoysk.reposilite.domain.depository.entities.Group;

import java.io.File;
import java.util.Map;

public class Depository {

    private final File root;
    private Map<String, Group> groups;

    Depository(File root) {
        this.root = root;
    }

    public void addGroup(Group group) {
        groups.put(group.getName(), group);
    }

    public Map<? extends String, ? extends Group> getGroups() {
        return groups;
    }

    public File getRootFile() {
        return root;
    }

    public String getName() {
        return root.getName();
    }

}
