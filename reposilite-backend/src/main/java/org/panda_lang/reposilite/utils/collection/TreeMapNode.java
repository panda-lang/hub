package org.panda_lang.reposilite.utils.collection;

import org.springframework.lang.Nullable;

import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;

public class TreeMapNode<T> {

    private final T element;
    private final Function<T, String> mapper;
    private final Map<String, TreeMapNode<T>> children;

    public TreeMapNode(T element, Function<T, String> mapper) {
        this.element = element;
        this.mapper = mapper;
        this.children = new HashMap<>();
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

    public void add(Collection<TreeMapNode<T>> nodes) {
        nodes.forEach(this::add);
    }

    public void add(TreeMapNode<T> node) {
        children.put(mapper.apply(node.getElement()), node);
    }

    public boolean isEmpty() {
        return children.isEmpty();
    }

    public Collection<TreeMapNode<? extends T>> getNodesStartingWith(String str) {
        Collection<TreeMapNode<? extends T>> nodes = new ArrayList<>();

        for (Map.Entry<String, TreeMapNode<T>> entry : children.entrySet()) {
            if (entry.getKey().startsWith(str)) {
                nodes.add(entry.getValue());
            }
        }

        return nodes;
    }

    public @Nullable TreeMapNode<? extends T> getNode(String nodeName) {
        return children.get(nodeName);
    }

    public @Nullable T get(String elementName) {
        TreeMapNode<? extends T> element = getNode(elementName);
        return element != null ? element.getElement() : null;
    }

    public Collection<TreeMapNode<T>> getChildren() {
        return children.values();
    }

    public String getName() {
        return mapper.apply(element);
    }

    public T getElement() {
        return element;
    }

}