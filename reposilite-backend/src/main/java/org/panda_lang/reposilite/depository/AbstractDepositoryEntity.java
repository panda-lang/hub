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

package org.panda_lang.reposilite.depository;

import org.panda_lang.utilities.commons.StringUtils;

import java.io.File;
import java.util.Collection;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public abstract class AbstractDepositoryEntity implements DepositoryEntity {

    private final String name;
    private final File file;
    private final DepositoryTree<?> node;

    protected AbstractDepositoryEntity(File file) {
        this.name = file.getName();
        this.file = file;
        this.node = new DepositoryTree<>(this, DepositoryEntity::getName);
    }

    protected AbstractDepositoryEntity(File root, String name) {
        this(new File(root, name));
    }

    @SuppressWarnings("unchecked")
    public <T extends DepositoryEntity> T createIfAbsent(String name, Function<String, T> entityFunction) {
        return (T) getChild(name).orElseGet(() -> {
            T entity = entityFunction.apply(name);
            addEntity(entity);
            return entity;
        });
    }

    @Override
    public void addEntity(DepositoryEntity entity) {
        node.add(entity.getNode());
    }

    @Override
    public Optional<DepositoryEntity> find(String path) {
        return Optional.ofNullable(node.find(StringUtils.split(path, "/")));
    }

    @Override
    public Optional<DepositoryEntity> getChild(String name) {
        return Optional.ofNullable(node.get(name));
    }

    protected <T extends DepositoryEntity> Map<String, ? extends T> getMappedChildrenOfType(Class<T> type) {
        return streamOfType(type).collect(Collectors.toMap(DepositoryEntity::getName, element -> element));
    }

    @Override
    public DepositoryTree<?> getNode() {
        return node;
    }

    @Override
    public Collection<String> getChildrenNames() {
        return toEntitiesStream()
                .map(DepositoryEntity::getName)
                .collect(Collectors.toList());
    }

    @Override
    public Collection<? extends DepositoryEntity> getChildren() {
        return toEntitiesStream().collect(Collectors.toList());
    }

    private Stream<? extends DepositoryEntity> toEntitiesStream() {
        return node.getChildren().stream().map(DepositoryTree::getElement);
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
