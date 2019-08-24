package org.panda_lang.reposilite;

import org.slf4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ReposiliteApplication {

    public static void main(String[] args) throws Exception {
        ReposiliteLogger.initializeMessage();
        ReposiliteExternalConfiguration.initialize();
        SpringApplication.run(ReposiliteApplication.class, args);
    }

    public static Logger getLogger() {
        return ReposiliteLogger.REPOSILITE_LOGGER;
    }

}
