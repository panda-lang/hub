package org.panda_lang.reposilite.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import org.bson.types.ObjectId;
import org.panda_lang.reposilite.depository.DepositoryOwner;
import org.panda_lang.reposilite.user.role.Role;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Set;

@Document("users")
public class User implements DepositoryOwner {

    @Id
    @JsonSerialize(using = ToStringSerializer.class)
    private ObjectId identifier;
    private String name;
    private String displayName;
    @JsonIgnore
    private String password;
    private String description;
    private String email;
    private String site;
    private Set<Role> roles;

    User(String name, String displayName, String password, String description, String email, String site, Set<Role> roles) {
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

    public void setRoles(Set<Role> roles) {
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

    public Set<Role> getRoles() {
        return this.roles;
    }

    public void addRole(Role role) {
        this.roles.add(role);
    }

    @Override
    public String toString() {
        return "User{" +
                "identifier=" + this.identifier +
                ", name='" + this.name + '\'' +
                ", displayName='" + this.displayName + '\'' +
                ", password='" + this.password + '\'' +
                ", description='" + this.description + '\'' +
                ", email='" + this.email + '\'' +
                ", site='" + this.site + '\'' +
                ", roles=" + this.roles +
                '}';
    }

}
