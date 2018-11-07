package org.panda_lang.reposilite.utils.collection;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.function.Predicate;

public class TreeNode<T> {

    private final T element;
    private final Set<TreeNode<T>> children;

    public TreeNode(T element) {
        this.element = element;
        this.children = new HashSet<>();
    }

    public Set<T> collectLeafs(Predicate<T> filter) {
        Set<T> leafs = new HashSet<>();

        for (TreeNode<T> child : children) {
            leafs.addAll(child.collectLeafs(filter));
        }

        if (leafs.isEmpty() && filter.test(getElement())) {
            leafs.add(getElement());
        }

        return leafs;
    }

    public void add(TreeNode<T> node) {
        this.children.add(node);
    }

    public void add(Collection<TreeNode<T>> nodes) {
        this.children.addAll(nodes);
    }

    public boolean isEmpty() {
        return children.isEmpty();
    }

    public Set<TreeNode<T>> getChildren() {
        return children;
    }

    public T getElement() {
        return element;
    }

}
