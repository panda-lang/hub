package org.panda_lang.reposilite.depository;

import org.panda_lang.reposilite.ReposiliteApplication;
import org.panda_lang.reposilite.depository.maven.MavenDepository;
import org.panda_lang.panda.utilities.commons.text.ContentJoiner;

public final class DepositoryUtils {

    public static void print(MavenDepository mavenDepository) {
        ReposiliteApplication.getLogger().info("└── " + mavenDepository.getName());
        mavenDepository.getGroups().forEach(group -> {
            ReposiliteApplication.getLogger().info("   ├── " + group.getName());
            group.getArtifacts().forEach(artifact -> ReposiliteApplication.getLogger().info("   │  ├── " + artifact.getName() + " { " + ContentJoiner.on(", ").join(artifact.getVersions()) + " }"));
        });
    }

    private DepositoryUtils() {
    }

}
