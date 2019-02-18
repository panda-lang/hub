package org.panda_lang.reposilite.utils;

import com.google.common.hash.Hashing;
import com.google.common.io.Files;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.panda_lang.reposilite.utils.collection.TreeNode;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Comparator;

/*
    @Source https://github.com/apache/commons-io/blob/master/src/main/java/org/apache/commons/io/FileUtils.java
 */

public final class FilesUtils {

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
        storeFile(path, file, true);
    }

    public static void storeFile(Path path, MultipartFile file, boolean xmlAllowed) {
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        Path directoryPath = path.resolve(fileName);

        if (!xmlAllowed && FilenameUtil.getExtension(file.getOriginalFilename()).contains("xml")) {
            return;
        }

        try {
            copyInputStreamToFile(file.getInputStream(), directoryPath.toFile());
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

            writeStringToFile(md5FileFile.toFile(), com.google.common.io.Files.hash(md5FileFile.toFile(), Hashing.md5()).toString(), StandardCharsets.UTF_8);
            writeStringToFile(sha1FileFile.toFile(), com.google.common.io.Files.hash(sha1FileFile.toFile(), Hashing.sha1()).toString(), StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void copyInputStreamToFile(InputStream source, File destination) throws IOException {
        try (InputStream in = source) {
            copyToFile(in, destination);
        }
    }

    public static void copyToFile(final InputStream source, File destination) throws IOException {
        try (OutputStream out = openOutputStream(destination, false)) {
            IOUtils.copy(source, out);
        }
    }

    public static FileOutputStream openOutputStream(File file, boolean append) throws IOException {
        if (file.exists()) {
            if (file.isDirectory()) {
                throw new IOException("File '" + file + "' exists but is a directory");
            }
            if (!file.canWrite()) {
                throw new IOException("File '" + file + "' cannot be written to");
            }
        }
        else {
            File parent = file.getParentFile();
            if (parent != null) {
                if (!parent.mkdirs() && !parent.isDirectory()) {
                    throw new IOException("Directory '" + parent + "' could not be created");
                }
            }
        }

        return new FileOutputStream(file, append);
    }

    public static void writeStringToFile(File file, String data, Charset encoding) throws IOException {
        try (OutputStream out = openOutputStream(file, false)) {
            write(data, out, encoding);
        }
    }

    public static void write(String data, OutputStream output, Charset encoding) throws IOException {
        if (data != null) {
            output.write(data.getBytes(encoding));
        }
    }

    private FilesUtils() {
    }
}
