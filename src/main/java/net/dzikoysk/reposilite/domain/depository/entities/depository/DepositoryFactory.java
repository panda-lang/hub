package net.dzikoysk.reposilite.domain.depository.entities.depository;

import net.dzikoysk.reposilite.ReposiliteApplication;
import net.dzikoysk.reposilite.domain.depository.DepositoryPath;
import net.dzikoysk.reposilite.domain.depository.entities.artifact.Artifact;
import net.dzikoysk.reposilite.domain.depository.entities.artifact.ArtifactFactory;
import net.dzikoysk.reposilite.domain.depository.entities.build.Build;
import net.dzikoysk.reposilite.domain.depository.entities.build.BuildFactory;
import net.dzikoysk.reposilite.domain.depository.entities.group.Group;
import net.dzikoysk.reposilite.domain.depository.entities.group.GroupFactory;
import net.dzikoysk.reposilite.utils.FilesUtils;
import net.dzikoysk.reposilite.utils.collection.TreeNode;
import org.panda_lang.panda.utilities.commons.objects.StringUtils;

import java.io.File;
import java.util.HashSet;
import java.util.Set;

public class DepositoryFactory {

    public Set<Depository> loadDepositories(File root) {
        Set<Depository> depositories = new HashSet<>();
        File[] depositoryDirectories = root.listFiles();

        if (depositoryDirectories == null) {
            return depositories;
        }

        for (File depositoryDirectory : depositoryDirectories) {
            if (!depositoryDirectory.isDirectory()) {
                ReposiliteApplication.getLogger().info("  Skipping " + depositoryDirectory.getName());
            }

            Depository depository = loadDepository(depositoryDirectory);
            depositories.add(depository);
        }

        return depositories;
    }

    public Depository loadDepository(File depositoryDirectory) {
        if (!depositoryDirectory.isDirectory()) {
            throw new IllegalArgumentException("Depository root file should be a directory");
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
        DepositoryPath depositoryPath = DepositoryPath.ofSystemPath(path);

        if (StringUtils.isEmpty(depositoryPath.getGroupName())) {
            return;
        }

        Group group = groupFactory.obtainGroup(depositoryPath.getGroupName());

        if (group == null) {
            return;
        }

        ArtifactFactory artifactFactory = new ArtifactFactory(group);
        Artifact artifact = artifactFactory.obtainArtifact(depositoryPath.getArtifactName());

        if (artifact == null) {
            return;
        }

        BuildFactory buildFactory = new BuildFactory(artifact);
        Build build = buildFactory.obtainBuild(depositoryPath.getBuildVersion());

        if (build == null || StringUtils.isEmpty(depositoryPath.getBuildFile())) {
            return;
        }

        build.addContent(file);
    }

}
