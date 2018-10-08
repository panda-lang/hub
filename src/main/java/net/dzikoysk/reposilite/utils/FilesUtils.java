package net.dzikoysk.reposilite.utils;

import net.dzikoysk.reposilite.utils.collection.TreeNode;

import java.io.File;

public class FilesUtils {

    public static TreeNode<File> collectFiles(File directory) {
        TreeNode<File> tree = new TreeNode<>(directory);

        if (!directory.isDirectory()) {
            return tree;
        }

        File[] files = directory.listFiles();

        if (files == null) {
            return tree;
        }

        for (File file : files) {
            tree.add(file.isDirectory() ? collectFiles(file) : new TreeNode<>(file));
        }

        return tree;
    }

}
