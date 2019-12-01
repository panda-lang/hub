/*
 * Copyright (c) 2018-2019 Reposilite Team
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.panda_lang.reposilite.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import org.bson.types.ObjectId;
import org.panda_lang.reposilite.user.role.Role;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Set;

@Document("users")
public final class User implements Owner {

    @Id
    @JsonSerialize(using = ToStringSerializer.class)
    private ObjectId identifier;
    private String name;
    private String displayName;
    @JsonIgnore
    private String password;
    private String description;
    private String email;
    private String provider;
    private String providerId;
    private String avatar;
    private String site;
    private Set<Role> roles;

    User(String name, String displayName, String password, String description, String email, String provider, String providerId, String avatar, String site, Set<Role> roles) {
        this.name = name;
        this.displayName = displayName;
        this.password = password;
        this.description = description;
        this.email = email;
        this.provider = provider;
        this.providerId = providerId;
        this.avatar = avatar;
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

    public void setProvider(String provider) {
        this.provider = provider;
    }

    public void setProviderId(String providerId) {
        this.providerId = providerId;
    }

    @Override
    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    @Override
    public void setSite(String site) {
        this.site = site;
    }

    public void addRoles(Set<Role> roles) {
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

    public String getProvider() {
        return provider;
    }

    public String getProviderId() {
        return providerId;
    }

    @Override
    public String getAvatar() {
        return avatar;
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

    public static UserBuilder builder() {
        return new UserBuilder();
    }

}
