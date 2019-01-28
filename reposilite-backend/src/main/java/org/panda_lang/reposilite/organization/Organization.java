package org.panda_lang.reposilite.organization;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import org.bson.types.ObjectId;
import org.panda_lang.reposilite.depository.DepositoryOwner;
import org.panda_lang.reposilite.user.User;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Organization implements DepositoryOwner {

    @Id
    @JsonSerialize(using = ToStringSerializer.class)
    private ObjectId identifier;
    private String name;
    private String displayName;
    private String description;
    private String email;
    private String site;
    private User owner;

    Organization() {}

    Organization(String name, String displayName, String description, String email, String site, User owner) {
        this.name = name;
        this.displayName = displayName;
        this.description = description;
        this.email = email;
        this.site = site;
        this.owner = owner;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    @Override
    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public void setSite(String site) {
        this.site = site;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    @Override
    public ObjectId getIdentifier() {
        return this.identifier;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getDisplayName() {
        return this.displayName;
    }

    @Override
    public String getDescription() {
        return this.description;
    }

    @Override
    public String getEmail() {
        return this.email;
    }

    @Override
    public String getSite() {
        return this.site;
    }

    public User getOwner() {
        return this.owner;
    }

    @Override
    public String toString() {
        return "Organization{" +
                "identifier=" + this.identifier +
                ", name='" + this.name + '\'' +
                ", displayName='" + this.displayName + '\'' +
                ", description='" + this.description + '\'' +
                ", email='" + this.email + '\'' +
                ", site='" + this.site + '\'' +
                ", owner=" + this.owner +
                '}';
    }

}
