package net.dzikoysk.reposilite.domain.depository;

import net.dzikoysk.reposilite.utils.FilesUtils;
import net.dzikoysk.reposilite.utils.StringsUtils;
import net.dzikoysk.reposilite.utils.collection.TreeNode;
import org.panda_lang.panda.utilities.commons.redact.ContentJoiner;

import java.io.File;
import java.util.Arrays;
import java.util.Set;

public class DepositoryFactory {

    public Depository loadDepository(File depositoryDirectory) {
        if (!depositoryDirectory.isDirectory()) {
            throw new IllegalArgumentException("Depository root file should be a directory");
        }

        Depository depository = new Depository(depositoryDirectory);
        load(depository);

        return depository;
    }

    private void load(Depository depository) {
        TreeNode<File> tree = FilesUtils.collectFiles(depository.getRootFile());
        Set<File> leafFiles = tree.collectLeafs(file -> file.getName().endsWith(".jar"));

        for (File leafFile : leafFiles) {
            try {
                load(depository, leafFile);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void load(Depository depository, File file) {
        String path = file.toString().replace(depository.getRootFile().toString(), "");

        int buildNameIndex = path.lastIndexOf(File.separator);
        int buildVersionIndex = StringsUtils.lastIndexOf(path, File.separator, buildNameIndex);
        int artifactNameIndex = StringsUtils.lastIndexOf(path, File.separator, buildVersionIndex);

        String groupName = path.substring(1, artifactNameIndex);
        String artifactName = path.substring(artifactNameIndex + 1, buildVersionIndex);
        String buildVersion = path.substring(buildVersionIndex + 1, buildNameIndex);
        String buildName = path.substring(buildNameIndex + 1);

        System.out.println(new ContentJoiner(" | ").join(Arrays.asList(groupName.replace(File.separator, "."), artifactName, buildVersion, buildName)));
    }

}
