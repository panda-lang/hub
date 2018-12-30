package org.panda_lang.reposilite;

import org.panda_lang.panda.utilities.commons.FileUtils;
import org.panda_lang.panda.utilities.commons.IOUtils;

import java.io.File;

class ReposiliteExternalConfiguration {

    static void initialize() {
        File userConfiguration = new File("application.yml");

        if (userConfiguration.exists()) {
            return;
        }

        String content = IOUtils.convertStreamToString(ReposiliteApplication.class.getResourceAsStream("/external-application.yml"));

        if (content == null) {
            throw new RuntimeException("Cannot get content of external configuration file");
        }

        ReposiliteApplication.getLogger().info("Generating configuration file...");
        FileUtils.overrideFile(userConfiguration, content);

        ReposiliteApplication.getLogger().info("Complete the configuration and run Reposilite again");
        System.exit(0);
    }

}
