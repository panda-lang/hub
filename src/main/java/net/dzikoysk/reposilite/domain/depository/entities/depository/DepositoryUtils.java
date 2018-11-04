package net.dzikoysk.reposilite.domain.depository.entities.depository;

import net.dzikoysk.reposilite.ReposiliteApplication;
import net.dzikoysk.reposilite.domain.depository.entities.artifact.Artifact;
import net.dzikoysk.reposilite.domain.depository.entities.group.Group;
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
