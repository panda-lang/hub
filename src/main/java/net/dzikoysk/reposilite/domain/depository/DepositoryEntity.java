package net.dzikoysk.reposilite.domain.depository;

import net.dzikoysk.reposilite.utils.collection.TreeMapNode;

public interface DepositoryEntity {

    TreeMapNode<? extends DepositoryEntity> getNodes();

    String getName();

}
