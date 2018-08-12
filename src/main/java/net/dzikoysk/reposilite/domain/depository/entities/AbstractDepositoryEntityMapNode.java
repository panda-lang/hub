package net.dzikoysk.reposilite.domain.depository.entities;

import net.dzikoysk.reposilite.domain.depository.DepositoryEntity;
import net.dzikoysk.reposilite.utils.collection.TreeMapNode;
import org.panda_lang.panda.utilities.commons.arrays.ArrayDistributor;
import org.springframework.lang.Nullable;

import java.util.Collection;
import java.util.function.Function;

public class AbstractDepositoryEntityMapNode extends TreeMapNode<AbstractDepositoryEntity> {

    public AbstractDepositoryEntityMapNode(AbstractDepositoryEntity element, Function<AbstractDepositoryEntity, String> mapper) {
        super(element, mapper);
    }

    public @Nullable DepositoryEntity find(String... paths) {
        ArrayDistributor<String> distributor = new ArrayDistributor<>(paths);
        return distributor.hasNext() ? find(this, distributor) : null;
    }

    private @Nullable DepositoryEntity find(TreeMapNode<? extends AbstractDepositoryEntity> map, ArrayDistributor<String> distributor) {
        String path = distributor.next();
        TreeMapNode<? extends AbstractDepositoryEntity> elementNode = map.getNode(path);

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

    private @Nullable TreeMapNode<? extends AbstractDepositoryEntity> match(TreeMapNode<? extends AbstractDepositoryEntity> map, String previousPath, ArrayDistributor<String> distributor) {
        StringBuilder path = new StringBuilder(previousPath)
                .append(".")
                .append(distributor.next());

        Collection<? extends TreeMapNode<? extends AbstractDepositoryEntity>> lastPossibleNodes = map.getNodesStartingWith(path.toString());

        if (distributor.hasNext() && lastPossibleNodes.size() == 0) {
            return null;
        }

        while (distributor.hasNext() && lastPossibleNodes.size() > 0) {
            String part = distributor.next();

            Collection<? extends TreeMapNode<? extends AbstractDepositoryEntity>> possibleNodes = map.getNodesStartingWith(path
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

        for (TreeMapNode<? extends AbstractDepositoryEntity> lastPossibleNode : lastPossibleNodes) {
            if (lastPossibleNode.getName().equals(fullPath)) {
                return lastPossibleNode;
            }
        }

        return null;
    }

}
