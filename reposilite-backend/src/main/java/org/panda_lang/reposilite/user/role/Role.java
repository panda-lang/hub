package org.panda_lang.reposilite.user.role;

import org.bson.types.ObjectId;
import org.panda_lang.reposilite.utils.IdentifiableEntity;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Role implements IdentifiableEntity<ObjectId> {

    @Id
    private ObjectId identifier;
    private String name;

    public Role(String name) {
        this.name = name;
    }

    @Override
    public ObjectId getIdentifier() {
        return identifier;
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
