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

package org.panda_lang.reposilite.resource;

import org.panda_lang.utilities.commons.StringUtils;

import java.io.File;
import java.util.Collection;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public abstract class AbstractResource implements Resource {

    private final String name;
    private final File file;
    private final ResourcesTree<?> node;

    protected AbstractResource(File file) {
        this.name = file.getName();
        this.file = file;
        this.node = new ResourcesTree<>(this, Resource::getName);
    }

    protected AbstractResource(File root, String name) {
        this(new File(root, name));
    }

    @SuppressWarnings("unchecked")
    public <T extends Resource> T createIfAbsent(String name, Function<String, T> entityFunction) {
        return (T) getChild(name).orElseGet(() -> {
            T entity = entityFunction.apply(name);
            addEntity(entity);
            return entity;
        });
    }

    @Override
    public void addEntity(Resource entity) {
        node.add(entity.toNode());
    }

    @Override
    public Optional<Resource> find(String path) {
        return Optional.ofNullable(node.find(StringUtils.split(path, "/")));
    }

    @Override
    public Optional<Resource> getChild(String name) {
        return Optional.ofNullable(node.get(name));
    }

    protected <T extends Resource> Map<String, ? extends T> getMappedChildrenOfType(Class<T> type) {
        return streamOfType(type).collect(Collectors.toMap(Resource::getName, element -> element));
    }

    @Override
    @SuppressWarnings("unchecked")
    public <T extends Resource> Stream<T> streamOfType(Class<T> type) {
        return getChildren().stream()
                .filter(element -> type.isAssignableFrom(element.getClass()))
                .map(element -> (T) element);
    }

    @Override
    public ResourcesTree<?> toNode() {
        return node;
    }

    @Override
    public Collection<String> getChildrenNames() {
        return toEntitiesStream()
                .map(Resource::getName)
                .collect(Collectors.toList());
    }

    @Override
    public Collection<? extends Resource> getChildren() {
        return toEntitiesStream().collect(Collectors.toList());
    }

    private Stream<? extends Resource> toEntitiesStream() {
        return node.getChildren().stream().map(ResourcesTree::getElement);
    }

    @Override
    public File getFile() {
        return file;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return getName();
    }

}
