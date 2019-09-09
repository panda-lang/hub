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

import org.panda_lang.panda.utilities.commons.collection.map.TreemapNode;

import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public interface DepositoryEntity {

    /**
     * Find entity using uri
     *
     * @param uri the path to search for
     * @return the found entity
     */
    Optional<DepositoryEntity> find(String uri);

    @SuppressWarnings("unchecked")
    default  <T extends DepositoryEntity> Stream<T> streamOfType(Class<T> type) {
        return getChildren().stream()
                .filter(element -> type.isAssignableFrom(element.getClass()))
                .map(element -> (T) element);
    }

    /**
     * Add entity as a child to the current entity
     *
     * @param child the entity to add
     */
    void addEntity(DepositoryEntity child);

    /**
     * Get collection of child entities of the requested type
     *
     * @param type the type of entity to search for
     * @param <T> the type of entity
     * @return collection of requested entities
     */
    default <T extends DepositoryEntity> Collection<? extends T> getChildrenOfType(Class<T> type) {
        return streamOfType(type).collect(Collectors.toList());
    }

    /**
     * Get names of children
     *
     * @return the children names
     */
    Collection<String> getChildrenNames();

    /**
     * Get collection of child entities
     *
     * @return the child entities
     */
    Collection<? extends DepositoryEntity> getChildren();

    /**
     * Get node used by entity
     *
     * @return the node
     */
    TreemapNode<DepositoryEntity> getNode();

    /**
     * Get name used in addresses
     *
     * @return the uri name
     */
    String getURIName();

    /**
     * Get display name of entity
     *
     * @return the name
     */
    String getName();

}
