package net.dzikoysk.reposilite.utils.collection;

import java.util.*;
import java.util.function.Predicate;

public class TreeMapNode<T> {

    private final T element;
    private final Map<String, TreeMapNode<T>> children;

    public TreeMapNode(T element) {
        this.element = element;
        this.children = new HashMap<>();
    }

    public T find(String... paths) {
        return null;
    }

    public Set<T> collectLeafs(Predicate<T> filter) {
        Set<T> leafs = new HashSet<>();

        for (Map.Entry<String, TreeMapNode<T>> child : children.entrySet()) {
            leafs.addAll(child.getValue().collectLeafs(filter));
        }

        if (leafs.isEmpty() && filter.test(getElement())) {
            leafs.add(getElement());
        }

        return leafs;
    }

    public void add(TreeMapNode<T> node) {
        this.children.put(node.getElement().toString(), node);
    }

    public void add(Collection<TreeMapNode<T>> nodes) {
        nodes.forEach(this::add);
    }

    public boolean isEmpty() {
        return children.isEmpty();
    }

    public Collection<TreeMapNode<T>> getChildren() {
        return children.values();
    }

    public T getElement() {
        return element;
    }

}