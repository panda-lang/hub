package org.panda_lang.reposilite.utils.entity.crud;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import org.bson.types.ObjectId;
import org.panda_lang.reposilite.utils.entity.IdentifiableEntity;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("tests")
public class TestEntity implements IdentifiableEntity<ObjectId> {

    @Id
    @JsonSerialize(using = ToStringSerializer.class)
    private ObjectId identifier;
    private String username;
    private String something;

    public TestEntity(ObjectId identifier, String username, String something) {
        this.identifier = identifier;
        this.username = username;
        this.something = something;
    }

    public TestEntity() { // JACKSON
    }

    @Override
    public ObjectId getIdentifier() {
        return this.identifier;
    }

    public String getUsername() {
        return this.username;
    }

    public String getSomething() {
        return this.something;
    }

    public void setIdentifier(ObjectId identifier) {
        this.identifier = identifier;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setSomething(String something) {
        this.something = something;
    }

    @Override
    public String toString() {
        return "TestEntity{" +
                "identifier=" + this.identifier +
                ", username='" + this.username + '\'' +
                ", something='" + this.something + '\'' +
                '}';
    }

}
