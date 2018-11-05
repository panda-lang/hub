package net.dzikoysk.reposilite.depository;

import net.dzikoysk.reposilite.utils.collection.TreeMapNode;
import org.springframework.lang.Nullable;

import java.util.Collection;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public abstract class AbstractDepositoryEntity implements DepositoryEntity {

    private final String name;
    private final AbstractDepositoryEntityMapNode node;

    protected AbstractDepositoryEntity(String name) {
        this.name = name;
        this.node = new AbstractDepositoryEntityMapNode(this, DepositoryEntity::getName);
    }

    @Override
    public @Nullable DepositoryEntity find(String... paths) {
        return node.find(paths);
    }

    protected void addElement(AbstractDepositoryEntity entity) {
        node.add(entity.getNode());
    }

    @SuppressWarnings("unchecked")
    protected <T extends DepositoryEntity> Stream<T> streamOfType(Class<T> type) {
        return node.getChildren().stream()
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
    public TreeMapNode<AbstractDepositoryEntity> getNode() {
        return node;
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
