package org.panda_lang.reposilite.depository.maven;

import org.panda_lang.panda.utilities.commons.StringUtils;
import org.panda_lang.panda.utilities.commons.collection.map.TreeNode;
import org.panda_lang.reposilite.ReposiliteApplication;
import org.panda_lang.reposilite.depository.DepositoryUtils;
import org.panda_lang.reposilite.depository.maven.artifact.Artifact;
import org.panda_lang.reposilite.depository.maven.artifact.ArtifactFactory;
import org.panda_lang.reposilite.depository.maven.build.Build;
import org.panda_lang.reposilite.depository.maven.build.BuildFactory;
import org.panda_lang.reposilite.depository.maven.group.Group;
import org.panda_lang.reposilite.depository.maven.group.GroupFactory;
import org.panda_lang.reposilite.utils.FilesUtils;

import java.io.File;
import java.util.HashSet;
import java.util.Set;

public class MavenDepositoryFactory {

    public Set<MavenDepository> loadDepositories(File root) {
        Set<MavenDepository> depositories = new HashSet<>();
        File[] depositoryDirectories = root.listFiles();

        if (depositoryDirectories == null) {
            return depositories;
        }

        for (File depositoryDirectory : depositoryDirectories) {
            if (!depositoryDirectory.isDirectory()) {
                ReposiliteApplication.getLogger().info("  Skipping " + depositoryDirectory.getName());
                continue;
            }

            MavenDepository mavenDepository = loadDepository(depositoryDirectory);
            depositories.add(mavenDepository);
        }

        return depositories;
    }

    public MavenDepository loadDepository(File depositoryDirectory) {
        if (!depositoryDirectory.isDirectory()) {
            throw new IllegalArgumentException("MavenDepository root file should be a directory");
        }

        MavenDepository mavenDepository = new MavenDepository(depositoryDirectory);

        try {
            load(mavenDepository);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return mavenDepository;
    }

    private void load(MavenDepository mavenDepository) {
        GroupFactory groupFactory = new GroupFactory(mavenDepository);

        TreeNode<File> tree = FilesUtils.collectFiles(mavenDepository.getRootFile());
        Set<File> leafFiles = tree.collectLeafs(file -> file.getName().endsWith(".jar") || file.getName().endsWith(".pom"));

        for (File leafFile : leafFiles) {
            load(mavenDepository, groupFactory, leafFile);
        }

        DepositoryUtils.print(mavenDepository);
    }

    private void load(MavenDepository mavenDepository, GroupFactory groupFactory, File file) {
        String path = file.toString().replace(mavenDepository.getRootFile().toString(), "");
        MavenDepositoryPath mavenDepositoryPath = MavenDepositoryPath.ofSystemPath(path);

        if (StringUtils.isEmpty(mavenDepositoryPath.getGroupName())) {
            return;
        }

        Group group = groupFactory.obtainGroup(mavenDepositoryPath.getGroupName());

        if (group == null) {
            return;
        }

        ArtifactFactory artifactFactory = new ArtifactFactory(group);
        Artifact artifact = artifactFactory.obtainArtifact(mavenDepositoryPath.getArtifactName());

        if (artifact == null) {
            return;
        }

        BuildFactory buildFactory = new BuildFactory(artifact);
        Build build = buildFactory.obtainBuild(mavenDepositoryPath.getBuildVersion());

        if (build == null || StringUtils.isEmpty(mavenDepositoryPath.getBuildFile())) {
            return;
        }

        build.addContent(file);
    }

}
