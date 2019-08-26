package org.panda_lang.reposilite.depository.maven;

import org.panda_lang.panda.utilities.commons.text.ContentJoiner;
import org.panda_lang.reposilite.ReposiliteApplication;
import org.panda_lang.reposilite.depository.maven.artifact.Artifact;
import org.panda_lang.reposilite.depository.maven.group.Group;

final class MavenDepositoryUtils {

    private MavenDepositoryUtils() { }

    static void print(MavenDepository mavenDepository) {
        ReposiliteApplication.getLogger().info("└── " + mavenDepository.getName());

        for (Group group : mavenDepository.getGroups()) {
            ReposiliteApplication.getLogger().info("   ├── " + group.getName());

            for (Artifact artifact : group.getArtifacts()) {
                ReposiliteApplication.getLogger().info("   │  ├── " + artifact.getName() + " { " + ContentJoiner.on(", ").join(artifact.getVersions()) + " }");
            }
        }
    }

}
