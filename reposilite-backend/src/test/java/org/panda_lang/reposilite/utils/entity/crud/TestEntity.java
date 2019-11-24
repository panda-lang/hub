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
    private String name;
    private String something;

    public TestEntity(ObjectId identifier, String name, String something) {
        this.identifier = identifier;
        this.name = name;
        this.something = something;
    }

    public TestEntity() {
        // Jackson
    }

    @Override
    public ObjectId getIdentifier() {
        return this.identifier;
    }

    public String getName() {
        return this.name;
    }

    public String getSomething() {
        return this.something;
    }

    public void setIdentifier(ObjectId identifier) {
        this.identifier = identifier;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSomething(String something) {
        this.something = something;
    }

    @Override
    public String toString() {
        return "TestEntity{" +
                "identifier=" + this.identifier +
                ", name='" + this.name + '\'' +
                ", something='" + this.something + '\'' +
                '}';
    }

}
