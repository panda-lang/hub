package org.panda_lang.reposilite.depository.maven;

import org.panda_lang.panda.utilities.commons.StringUtils;
import org.panda_lang.panda.utilities.commons.text.ContentJoiner;
import org.panda_lang.reposilite.ReposiliteApplication;
import org.panda_lang.reposilite.depository.DepositoryEntity;

final class MavenUtils {

    private MavenUtils() { }

    static void print(Depository depository) {
        ReposiliteApplication.getLogger().info("└── " + depository.getName());

        for (Group group : depository.getGroups()) {
            printEntity(1, group);
        }
    }

    private static void printEntity(int level, DepositoryEntity entity) {
        if (entity instanceof Artifact) {
            Artifact artifact = (Artifact) entity;
            ReposiliteApplication.getLogger().info(StringUtils.buildSpace((level - 1) * 3) + "│  ├── " + artifact.getName() + " { " + ContentJoiner.on(", ").join(artifact.getVersions()) + " }");
        }
        else if (entity instanceof Group) {
            ReposiliteApplication.getLogger().info(StringUtils.buildSpace(level * 3) + "├── " + entity.getName());
            Group group = (Group) entity;

            for (DepositoryEntity child : group.getChildren()) {
                printEntity(level + 1, child);
            }
        }
    }

}
