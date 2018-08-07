package net.dzikoysk.reposilite.domain.depository;

import net.dzikoysk.reposilite.domain.depository.entities.Group;

import java.util.Map;

public class Depository {

    private final String name;
    private Map<String, Group> groups;

    public Depository(String name) {
        this.name = name;
    }

}
