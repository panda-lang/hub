package net.dzikoysk.reposilite.utils;

import java.io.File;

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

}
