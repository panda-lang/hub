package org.panda_lang.reposilite.depository;

import org.panda_lang.panda.utilities.commons.collection.map.TreemapNode;
import org.springframework.lang.Nullable;

public interface DepositoryEntity {

    @Nullable DepositoryEntity find(String... paths);

    TreemapNode<? extends DepositoryEntity> getNode();

    String getName();

}
