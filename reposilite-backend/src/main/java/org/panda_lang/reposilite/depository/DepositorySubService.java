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

import java.util.Collection;
import java.util.Optional;

public interface DepositorySubService {

    /**
     * Get entity
     *
     * @param entityQualifier the qualifier to search for
     * @return the found entity
     */
    Optional<? extends DepositoryEntity> findEntityByQualifier(String entityQualifier);

    /**
     * Check if service is enabled
     *
     * @return true if enabled, otherwise false
     */
    default boolean isEnabled() {
        return true;
    }

    /**
     * Get all available entities
     *
     * @return the list of entities
     */
    Collection<? extends DepositoryEntity> getEntities();

    /**
     * Get sub service name
     *
     * @return the name of sub service
     */
    String getName();

}
