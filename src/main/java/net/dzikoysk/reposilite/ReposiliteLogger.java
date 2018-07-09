package net.dzikoysk.reposilite;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class ReposiliteLogger {

    static final Logger REPOSILITE_LOGGER = LoggerFactory.getLogger("Reposilite");

    static final String ASCII_LOGO = "\n" +
                                     " ____                      _ _ _ _        \n" +
                                     " |  _ \\ ___ _ __   ___  ___(_) (_) |_ ___  \n" +
                                     " | |_) / _ \\ '_ \\ / _ \\/ __| | | | __/ _ \\ \n" +
                                     " |  _ <  __/ |_) | (_) \\__ \\ | | | ||  __/ \n" +
                                     " |_| \\_\\___| .__/ \\___/|___/_|_|_|\\__\\___| \n" +
                                     "           |_|                             \n";

    static void initMessage() {
        if (Thread.currentThread().getName().contains("restarted")) {
            return;
        }

        System.out.println(ReposiliteLogger.ASCII_LOGO);
        System.out.println(" Version: " + ReposiliteConstants.REPOSILITE_VERSION);
        System.out.println(" Spring: " + ReposiliteConstants.SPRING_VERSION);
        System.out.println(" Spring Boot: " + ReposiliteConstants.SPRING_BOOT_VERSION);
        System.out.println();
    }

}
