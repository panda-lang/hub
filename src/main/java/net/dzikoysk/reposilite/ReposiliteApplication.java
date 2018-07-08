package net.dzikoysk.reposilite;

import org.jetbrains.annotations.*;
import org.slf4j.*;
import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;

@SpringBootApplication
public class ReposiliteApplication {

    public static void main(String[] args) {
        ReposiliteLogger.initMessage();
        SpringApplication.run(ReposiliteApplication.class, args);
    }

    @Contract(pure = true)
    public static Logger getLogger() {
        return ReposiliteLogger.REPOSILITE_LOGGER;
    }

}
