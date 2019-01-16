/*
 * MIT License
 *
 * Copyright (c) 2018 Coachy
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package org.panda_lang.reposilite.utils.crud;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import org.bson.types.ObjectId;
import org.panda_lang.reposilite.utils.IdentifiableEntity;
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
