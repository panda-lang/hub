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
