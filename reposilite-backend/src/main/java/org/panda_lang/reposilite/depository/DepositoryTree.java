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

import org.jetbrains.annotations.Nullable;
import org.panda_lang.utilities.commons.iterable.ArrayDistributor;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.function.Function;
import java.util.function.Predicate;

public class DepositoryTree<T extends DepositoryEntity> {

    private final T element;
    private final Function<DepositoryEntity, String> mapper;
    private final Map<String, DepositoryTree<?>> children;

    public DepositoryTree(T element, Function<DepositoryEntity, String> mapper) {
        this.element = element;
        this.mapper = mapper;
        this.children = new HashMap<>();
    }

    public Set<DepositoryEntity> collectLeafs(Predicate<DepositoryEntity> filter) {
        Set<DepositoryEntity> leafs = new HashSet<>();

        for (Map.Entry<String, DepositoryTree<?>> child : children.entrySet()) {
            leafs.addAll(child.getValue().collectLeafs(filter));
        }

        if (leafs.isEmpty() && filter.test(getElement())) {
            leafs.add(getElement());
        }

        return leafs;
    }

    public @Nullable DepositoryEntity find(String... paths) {
        ArrayDistributor<String> distributor = new ArrayDistributor<>(paths);
        return distributor.hasNext() ? find(this, distributor) : null;
    }

    private @Nullable DepositoryEntity find(DepositoryTree<?> map, ArrayDistributor<String> distributor) {
        String path = distributor.next();
        DepositoryTree<?> elementNode = map.getNode(path);

        if (elementNode == null && distributor.hasNext()) {
            elementNode = match(map, path, distributor);
        }

        if (elementNode == null) {
            return null;
        }

        if (distributor.hasNext()) {
            return find(elementNode, distributor);
        }

        return elementNode.getElement();
    }

    private @Nullable DepositoryTree<?> match(DepositoryTree<?> map, String previousPath, ArrayDistributor<String> distributor) {
        StringBuilder path = new StringBuilder(previousPath)
                .append(".")
                .append(distributor.next());

        Collection<? extends DepositoryTree<?>> lastPossibleNodes = map.getNodesStartingWith(path.toString());

        if (distributor.hasNext() && lastPossibleNodes.size() == 0) {
            return null;
        }

        while (distributor.hasNext()) {
            String part = distributor.next();

            if (part == null) {
                return null;
            }

            Collection<? extends DepositoryTree<?>> possibleNodes = map.getNodesStartingWith(
                    path.append(".").append(part).toString()
            );

            if (possibleNodes.size() == 0) {
                path.setLength(path.length() - part.length() - 1);
                distributor.previous();
                break;
            }

            lastPossibleNodes = possibleNodes;
        }

        String fullPath = path.toString();

        for (DepositoryTree<?> lastPossibleNode : lastPossibleNodes) {
            if (lastPossibleNode.getName().equals(fullPath)) {
                return lastPossibleNode;
            }
        }

        return null;
    }

    public void add(DepositoryTree<?> node) {
        children.put(mapper.apply(node.getElement()), node);
    }

    public @Nullable DepositoryEntity get(String elementName) {
        DepositoryTree<?> element = getNode(elementName);
        return element != null ? element.getElement() : null;
    }

    public Collection<DepositoryTree<?>> getNodesStartingWith(String str) {
        Collection<DepositoryTree<?>> nodes = new ArrayList<>();

        for (Entry<String, DepositoryTree<?>> entry : children.entrySet()) {
            if (entry.getKey().startsWith(str)) {
                nodes.add(entry.getValue());
            }
        }

        return nodes;
    }

    public @Nullable DepositoryTree<?> getNode(String nodeName) {
        return children.get(nodeName);
    }

    public Collection<DepositoryTree<?>> getChildren() {
        return children.values();
    }

    public String getName() {
        return mapper.apply(element);
    }

    public T getElement() {
        return element;
    }

}