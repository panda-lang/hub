package org.panda_lang.reposilite.depository;

import org.panda_lang.panda.utilities.commons.collection.map.TreemapNode;
import org.panda_lang.panda.utilities.commons.iterable.ArrayDistributor;
import org.springframework.lang.Nullable;

import java.util.Collection;
import java.util.function.Function;

public class AbstractDepositoryEntityMapNode extends TreemapNode<DepositoryEntity> {

    public AbstractDepositoryEntityMapNode(DepositoryEntity element, Function<DepositoryEntity, String> mapper) {
        super(element, mapper);
    }

    public @Nullable DepositoryEntity find(String... paths) {
        ArrayDistributor<String> distributor = new ArrayDistributor<>(paths);
        return distributor.hasNext() ? find(this, distributor) : null;
    }

    private @Nullable DepositoryEntity find(TreemapNode<? extends DepositoryEntity> map, ArrayDistributor<String> distributor) {
        String path = distributor.next();
        TreemapNode<? extends DepositoryEntity> elementNode = map.getNode(path);

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

    private @Nullable TreemapNode<? extends DepositoryEntity> match(TreemapNode<? extends DepositoryEntity> map, String previousPath, ArrayDistributor<String> distributor) {
        StringBuilder path = new StringBuilder(previousPath)
                .append(".")
                .append(distributor.next());

        Collection<? extends TreemapNode<? extends DepositoryEntity>> lastPossibleNodes = map.getNodesStartingWith(path.toString());

        if (distributor.hasNext() && lastPossibleNodes.size() == 0) {
            return null;
        }

        while (distributor.hasNext()) {
            String part = distributor.next();

            if (part == null) {
                return null;
            }

            Collection<? extends TreemapNode<? extends DepositoryEntity>> possibleNodes = map.getNodesStartingWith(path
                    .append(".").append(part).toString()
            );

            if (possibleNodes.size() == 0) {
                path.setLength(path.length() - part.length() - 1);
                distributor.previous();
                break;
            }

            lastPossibleNodes = possibleNodes;
        }

        String fullPath = path.toString();

        for (TreemapNode<? extends DepositoryEntity> lastPossibleNode : lastPossibleNodes) {
            if (lastPossibleNode.getName().equals(fullPath)) {
                return lastPossibleNode;
            }
        }

        return null;
    }

}
