package net.dzikoysk.reposilite.depository;

import net.dzikoysk.reposilite.utils.collection.TreeMapNode;
import org.springframework.lang.Nullable;

public interface DepositoryEntity {

    @Nullable DepositoryEntity find(String... paths);

    TreeMapNode<? extends DepositoryEntity> getNode();

    String getName();

}
