package net.dzikoysk.reposilite.domain.depository.entities;

import net.dzikoysk.reposilite.domain.depository.DepositoryEntity;
import net.dzikoysk.reposilite.utils.collection.TreeMapNode;

import java.util.Collection;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public abstract class AbstractDepositoryEntity implements DepositoryEntity {

    protected final String name;
    protected final TreeMapNode<DepositoryEntity> nodes;

    protected AbstractDepositoryEntity(String name) {
        this.name = name;
        this.nodes = new TreeMapNode<>(this, DepositoryEntity::getName);
    }

    protected void addElement(DepositoryEntity entity) {
        nodes.add(entity);
    }

    @SuppressWarnings("unchecked")
    protected <T extends DepositoryEntity> Stream<T> streamOfType(Class<T> type) {
        return nodes.getChildren().stream()
                .filter(node -> type.isAssignableFrom(node.getElement().getClass()))
                .map(node -> (T) node.getElement());
    }

    protected <T extends DepositoryEntity> Collection<? extends T> getChildrenOfType(Class<T> type) {
        return streamOfType(type).collect(Collectors.toList());
    }

    protected <T extends DepositoryEntity> Map<String, ? extends T> getMappedChildrenOfType(Class<T> type) {
        return streamOfType(type).collect(Collectors.toMap(DepositoryEntity::getName, element -> element));
    }

    @Override
    public TreeMapNode<DepositoryEntity> getNodes() {
        return nodes;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return getName();
    }

}
