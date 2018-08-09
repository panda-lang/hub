package net.dzikoysk.reposilite.utils;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class FilesUtils {

    public static int getAmountOfFiles(File directory) {
        if (!directory.isDirectory()) {
            return 0;
        }

        File[] files = directory.listFiles();

        if (files == null) {
            return 0;
        }

        return files.length;
    }

    public static Map<String, File> mapDirectory(File directory) {
        Map<String, File> map = new HashMap<>();

        if (!directory.isDirectory()) {
            return map;
        }

        return map;
    }

}
