package net.dzikoysk.reposilite.depository;

import net.dzikoysk.reposilite.ReposiliteApplication;
import net.dzikoysk.reposilite.depository.artifact.Artifact;
import net.dzikoysk.reposilite.depository.Depository;
import net.dzikoysk.reposilite.depository.group.Group;
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
