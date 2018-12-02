package org.panda_lang.reposilite.utils;

import com.google.common.hash.Hashing;
import com.google.common.io.Files;
import org.apache.commons.io.FileUtils;
import org.panda_lang.reposilite.utils.collection.TreeNode;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Comparator;

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
            FileUtils.copyInputStreamToFile(file.getInputStream(), directoryPath.toFile());
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static File getMostRecentDirectory(Path directoryPath) {
        return Arrays.stream(directoryPath.toFile().listFiles())
                .filter(File::isDirectory)
                .max(Comparator.comparingLong(File::lastModified))
                .orElseGet(null);
    }

    public static void writeFileChecksums(Path path) {
        try {
            Files.touch(new File(path + ".md5"));
            Files.touch(new File(path + ".sha1"));

            Path md5FileFile = Paths.get(path + ".md5");
            Path sha1FileFile = Paths.get(path + ".sha1");

            FileUtils.writeStringToFile(md5FileFile.toFile(), com.google.common.io.Files.hash(md5FileFile.toFile(), Hashing.md5()).toString(), StandardCharsets.UTF_8);
            FileUtils.writeStringToFile(sha1FileFile.toFile(), com.google.common.io.Files.hash(sha1FileFile.toFile(), Hashing.sha1()).toString(), StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
