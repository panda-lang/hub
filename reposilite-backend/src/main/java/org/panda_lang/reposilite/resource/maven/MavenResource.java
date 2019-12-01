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

package org.panda_lang.reposilite.resource.maven;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.panda_lang.reposilite.resource.Resource;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.lang.Nullable;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Document("maven-resources")
final class MavenResource implements Resource<MavenResource> {

    @Id
    private String identifier;
    private String name;
    private String pathname;
    private MavenResourceType type;
    @DBRef
    @JsonManagedReference
    private @Nullable MavenResource parent;
    @DBRef
    @JsonBackReference
    private List<MavenResource> resources;

    MavenResource(String name, File file, MavenResourceType type, @Nullable MavenResource parent) {
        this.identifier = (parent != null ? parent.getIdentifier() + "/" : "") + name;
        this.name = name;
        this.pathname = file.getAbsolutePath();
        this.type = type;
        this.parent = parent;
        this.resources = new ArrayList<>(3);
    }

    MavenResource() {
        // Jackson
    }

    @Override
    public boolean isLoadable() {
        return type == MavenResourceType.BUILD;
    }

    @Override
    public void addResource(MavenResource resource) {
        resources.add(resource);
    }

    @Override
    public Optional<MavenResource> getResource(String name) {
        return resources.stream()
                .filter(resource -> resource.name.equals(name))
                .findFirst();
    }

    @Override
    public List<? extends MavenResource> getResources() {
        return resources;
    }

    Optional<MavenResource> getParent() {
        return Optional.ofNullable(parent);
    }

    MavenResourceType getType() {
        return type;
    }

    @Override
    public File getFile() {
        return new File(pathname);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getIdentifier() {
        return identifier;
    }

}
