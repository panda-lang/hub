package org.panda_lang.reposilite.depository;

import org.panda_lang.reposilite.ReposiliteApplication;
import org.panda_lang.reposilite.depository.artifact.Artifact;
import org.panda_lang.reposilite.depository.group.Group;
import org.panda_lang.panda.utilities.commons.text.ContentJoiner;

public class DepositoryUtils {

    public static void print(Depository depository) {
        ReposiliteApplication.getLogger().info("└── " + depository.getName());

        for (Group group : depository.getGroups()) {
            ReposiliteApplication.getLogger().info("   ├── " + group.getName());

            for (Artifact artifact : group.getArtifacts()) {
                ReposiliteApplication.getLogger().info("   │  ├── " + artifact.getName() + " { " + ContentJoiner.on(", ").join(artifact.getVersions()) + " }");
            }
        }
    }

    private DepositoryUtils() { }

}
