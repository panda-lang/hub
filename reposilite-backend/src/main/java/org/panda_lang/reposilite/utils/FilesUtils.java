package org.panda_lang.reposilite.utils;

import org.panda_lang.reposilite.utils.collection.TreeNode;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public class FilesUtils {

    public static TreeNode<File> collectFiles(File directory) {
        TreeNode<File> tree = new TreeNode<>(directory);
        File[] files = directory.listFiles();

        if (files == null || files.length == 0) {
            return tree;
        }

        for (File file : files) {
            tree.add(file.isDirectory() ? collectFiles(file) : new TreeNode<>(file));
        }

        return tree;
    }

    public static void storeFile(Path path, MultipartFile file) {
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        Path directoryPath = path.resolve(fileName);

        try {
            Files.copy(file.getInputStream(), directoryPath, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

}
