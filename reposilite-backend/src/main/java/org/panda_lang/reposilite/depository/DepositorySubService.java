package org.panda_lang.reposilite.depository;

import java.util.Optional;
import java.util.Set;

public interface DepositorySubService {

    /**
     * Get entity
     *
     * @param entityQualifier the qualifier to search for
     * @return the found entity
     */
    Optional<DepositoryEntity> findEntity(String entityQualifier);

    /**
     * Get all available entities
     *
     * @return the list of entities
     */
    Set<? extends DepositoryEntity> getEntities();

    /**
     * Get sub service name
     *
     * @return the name of sub service
     */
    String getName();

}
