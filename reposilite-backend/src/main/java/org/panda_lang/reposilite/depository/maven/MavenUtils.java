/*
 * Copyright (c) 2018-2019 Reposilite Team
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

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

    static int lastIndexOf(String text, String element, int toIndex) {
        if (toIndex < 0) {
            return -1;
        }

        return text.substring(0, toIndex).lastIndexOf(element);
    }

}
