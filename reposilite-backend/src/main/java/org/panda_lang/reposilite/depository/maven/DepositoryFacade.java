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

import org.panda_lang.reposilite.ReposiliteApplication;
import org.panda_lang.reposilite.depository.DepositoryUtils;
import org.panda_lang.reposilite.utils.FilesUtils;
import org.panda_lang.utilities.commons.StringUtils;
import org.panda_lang.utilities.commons.collection.map.TreeNode;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.HashSet;
import java.util.Set;

@Service
final class DepositoryFacade {

    public Set<Depository> loadDepositories(File root) {
        Set<Depository> depositories = new HashSet<>();
        File[] depositoryDirectories = root.listFiles();

        if (depositoryDirectories == null) {
            return depositories;
        }

        for (File depositoryDirectory : depositoryDirectories) {
            if (!depositoryDirectory.isDirectory()) {
                ReposiliteApplication.getLogger().info("  Skipping " + depositoryDirectory.getName());
                continue;
            }

            Depository depository = loadDepository(depositoryDirectory);
            depositories.add(depository);
        }

        return depositories;
    }

    public Depository loadDepository(File depositoryDirectory) {
        if (!depositoryDirectory.isDirectory()) {
            throw new IllegalArgumentException("MavenDepository root file should be a directory");
        }

        Depository depository = new Depository(depositoryDirectory);

        try {
            load(depository);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return depository;
    }

    private void load(Depository depository) {
        GroupFactory groupFactory = new GroupFactory(depository);

        TreeNode<File> tree = FilesUtils.collectFiles(depository.getRootFile());
        Set<File> leafFiles = tree.collectLeafs(file -> file.getName().endsWith(".jar") || file.getName().endsWith(".pom"));

        for (File leafFile : leafFiles) {
            load(depository, groupFactory, leafFile);
        }

        DepositoryUtils.print(depository);
    }

    private void load(Depository depository, GroupFactory groupFactory, File file) {
        String path = file.toString().replace(depository.getRootFile().toString(), "");
        MavenMetadata mavenMetadata = MavenMetadata.ofSystemPath(path);

        if (StringUtils.isEmpty(mavenMetadata.getGroupName())) {
            return;
        }

        Group group = groupFactory.obtainGroup(mavenMetadata.getGroupName());

        if (group == null) {
            return;
        }

        ArtifactFactory artifactFactory = new ArtifactFactory(group);
        Artifact artifact = artifactFactory.obtainArtifact(mavenMetadata.getArtifactName());

        BuildFactory buildFactory = new BuildFactory(artifact);
        Build build = buildFactory.obtainBuild(mavenMetadata.getBuildVersion());

        if (StringUtils.isEmpty(mavenMetadata.getBuildFile())) {
            return;
        }

        build.addContent(file);
    }

}
