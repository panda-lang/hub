package org.panda_lang.reposilite.depository;

import org.panda_lang.reposilite.utils.collection.TreeMapNode;
import org.springframework.lang.Nullable;

public interface DepositoryEntity {

    @Nullable DepositoryEntity find(String... paths);

    TreeMapNode<? extends DepositoryEntity> getNode();

    String getName();

}
