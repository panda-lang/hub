package org.panda_lang.reposilite;

import org.jetbrains.annotations.Contract;
import org.slf4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ReposiliteApplication {

    public static void main(String[] args) {
        ReposiliteLogger.initializeMessage();
        SpringApplication.run(ReposiliteApplication.class, args);
    }

    @Contract(pure = true)
    public static Logger getLogger() {
        return ReposiliteLogger.REPOSILITE_LOGGER;
    }

}
