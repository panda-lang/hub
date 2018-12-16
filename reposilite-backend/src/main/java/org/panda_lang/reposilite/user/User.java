package org.panda_lang.reposilite.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.bson.types.ObjectId;
import org.panda_lang.reposilite.depository.DepositoryOwner;
import org.panda_lang.reposilite.user.role.Role;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
public class User implements DepositoryOwner {

    @Id
    private ObjectId identifier;
    private String name;
    private String displayName;
    @JsonIgnore
    private String password;
    private String description;
    private String email;
    private String site;
    private List<Role> roles;

    User(String name, String displayName, String password, String description, String email, String site, List<Role> roles) {
        this.name = name;
        this.displayName = displayName;
        this.password = password;
        this.description = description;
        this.email = email;
        this.site = site;
        this.roles = roles;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public void setRoles(List<Role> roles) {
        this.roles = roles;
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

    public String getPassword() {
        return this.password;
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

    public List<Role> getRoles() {
        return this.roles;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", displayName='" + displayName + '\'' +
                ", email='" + email + '\'' +
                ", roles=" + roles +
                '}';
    }
}
