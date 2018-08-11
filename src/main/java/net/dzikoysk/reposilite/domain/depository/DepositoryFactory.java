package net.dzikoysk.reposilite.domain.depository;

import net.dzikoysk.reposilite.ReposiliteApplication;
import net.dzikoysk.reposilite.domain.depository.entities.*;
import net.dzikoysk.reposilite.utils.FilesUtils;
import net.dzikoysk.reposilite.utils.collection.TreeNode;
import org.panda_lang.panda.utilities.commons.redact.ContentJoiner;

import java.io.File;
import java.util.Arrays;
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

            try {
                Depository depository = loadDepository(depositoryDirectory);
                depositories.add(depository);

                ReposiliteApplication.getLogger().info("  - " + depository.getName());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return depositories;
    }

    public Depository loadDepository(File depositoryDirectory) {
        if (!depositoryDirectory.isDirectory()) {
            throw new IllegalArgumentException("Depository root file should be a directory");
        }

        Depository depository = new Depository(depositoryDirectory);
        load(depository);

        return depository;
    }

    private void load(Depository depository) {
        GroupFactory groupFactory = new GroupFactory(depository);

        TreeNode<File> tree = FilesUtils.collectFiles(depository.getRootFile());
        Set<File> leafFiles = tree.collectLeafs(file -> file.getName().endsWith(".jar") || file.getName().endsWith(".pom"));

        for (File leafFile : leafFiles) {
            load(depository, groupFactory, leafFile);
        }
    }

    private void load(Depository depository, GroupFactory groupFactory, File file) {
        String path = file.toString().replace(depository.getRootFile().toString(), "");
        DepositoryPath depositoryPath = DepositoryPath.ofSystemPath(path);

        System.out.println(new ContentJoiner(" | ").join(Arrays.asList(depositoryPath.toArray())));

        Group group = groupFactory.obtainGroup(depositoryPath.getGroupName());
        ArtifactFactory artifactFactory = new ArtifactFactory(group);
        Artifact artifact = artifactFactory.obtainArtifact(depositoryPath.getArtifactName());
        Build build = artifactFactory.obtainBuild(artifact, depositoryPath.getBuildVersion());

        build.addContent(file);
        artifact.addBuild(build);
        group.addArtifact(artifact);
        depository.addGroup(group);
    }

}
