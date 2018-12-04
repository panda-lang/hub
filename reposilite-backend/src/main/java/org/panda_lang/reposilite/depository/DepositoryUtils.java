package org.panda_lang.reposilite.depository;

import org.panda_lang.reposilite.ReposiliteApplication;
import org.panda_lang.reposilite.depository.maven.MavenDepository;
import org.panda_lang.panda.utilities.commons.text.ContentJoiner;
import org.panda_lang.reposilite.depository.maven.artifact.Artifact;
import org.panda_lang.reposilite.depository.maven.group.Group;

public final class DepositoryUtils {

    public static void print(MavenDepository mavenDepository) {
        ReposiliteApplication.getLogger().info("└── " + mavenDepository.getName());

        for (Group group : mavenDepository.getGroups()) {
            ReposiliteApplication.getLogger().info("   ├── " + group.getName());

            for (Artifact artifact : group.getArtifacts()) {
                ReposiliteApplication.getLogger().info("   │  ├── " + artifact.getName() + " { " + ContentJoiner.on(", ").join(artifact.getVersions()) + " }");
            }
        }
    }

    private DepositoryUtils() {
    }

}
