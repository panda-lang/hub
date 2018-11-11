package org.panda_lang.reposilite.user.role;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Role {

    @Id
    private long identifier;
    private String name;

    public Role(String name) {
        this.name = name;
    }

    public long getIdentifier() {
        return identifier;
    }

    public void setIdentifier(long identifier) {
        this.identifier = identifier;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Role{" +
                "identifier=" + identifier +
                ", name='" + name + '\'' +
                '}';
    }

}
