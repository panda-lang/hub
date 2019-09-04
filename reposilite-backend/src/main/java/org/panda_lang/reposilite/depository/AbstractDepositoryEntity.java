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

import org.panda_lang.panda.utilities.commons.StringUtils;
import org.panda_lang.panda.utilities.commons.collection.map.TreemapNode;

import java.util.Collection;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public abstract class AbstractDepositoryEntity implements DepositoryEntity {

    private final String name;
    private final AbstractDepositoryEntityMapNode node;

    protected AbstractDepositoryEntity(String name) {
        this.name = name;
        this.node = new AbstractDepositoryEntityMapNode(this, DepositoryEntity::getName);
    }

    @Override
    public Optional<DepositoryEntity> find(String path) {
        return Optional.ofNullable(node.find(StringUtils.split(path, "/")));
    }

    @Override
    public void addEntity(DepositoryEntity entity) {
        node.add(entity.getNode());
    }

    protected <T extends DepositoryEntity> Map<String, ? extends T> getMappedChildrenOfType(Class<T> type) {
        return streamOfType(type).collect(Collectors.toMap(DepositoryEntity::getName, element -> element));
    }

    public TreemapNode<DepositoryEntity> getNode() {
        return node;
    }

    @Override
    public Collection<? extends DepositoryEntity> getChildren() {
        return node.getChildren().stream()
                .map(TreemapNode::getElement)
                .collect(Collectors.toList());
    }

    @Override
    public String getURIName() {
        return StringUtils.replaceFirst(getName(), ".", "/");
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
