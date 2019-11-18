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

import java.io.File;
import java.util.Collection;
import java.util.Optional;
import java.util.stream.Stream;

public interface DepositoryEntity {

    /**
     * Find entity using uri
     *
     * @param uri the path to search for
     * @return the found entity
     */
    Optional<DepositoryEntity> find(String uri);

    /**
     * Add entity as a child to the current entity
     *
     * @param child the entity to add
     */
    void addEntity(DepositoryEntity child);

    /**
     * Get node used by entity
     *
     * @return the node
     */
    DepositoryTree<?> toNode();

    /**
     * Get children stream of the given type
     *
     * @param type the type of children
     * @param <T> generic representation of type
     * @return the type
     */
     <T extends DepositoryEntity> Stream<T> streamOfType(Class<T> type);

    /**
     * Check if entity has child with the given name
     *
     * @param name the name to check for
     * @return true if entity has
     */
    Optional<DepositoryEntity> getChild(String name);

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
     * Get associated file
     *
     * @return the file
     */
    File getFile();

    /**
     * Get display name of entity
     *
     * @return the name
     */
    String getName();

}
