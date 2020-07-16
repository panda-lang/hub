/*
 * Copyright (c) 2018-2019 Hub Team
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

package org.panda_lang.hub.organization;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import org.bson.types.ObjectId;
import org.panda_lang.hub.user.Owner;
import org.panda_lang.hub.user.User;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("organizations")
public final class Organization implements Owner {

    @Id
    @JsonSerialize(using = ToStringSerializer.class)
    private ObjectId identifier;
    private String name;
    private String displayName;
    private String description;
    private String email;
    private String avatar;
    private String site;
    private User owner;

    Organization(String name, String displayName, String description, String email, String avatar, String site, User owner) {
        this.name = name;
        this.displayName = displayName;
        this.description = description;
        this.email = email;
        this.site = site;
        this.avatar = avatar;
        this.owner = owner;
    }

    Organization() {
        // Jackson
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
    public void setAvatar(String avatar) {
        this.avatar = avatar;
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
    public String getAvatar() {
        return avatar;
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
