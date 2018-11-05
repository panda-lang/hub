package net.dzikoysk.reposilite.depository;

import net.dzikoysk.reposilite.utils.StringsUtils;

import java.io.File;

public class DepositoryPath {

    private final String groupName;
    private final String artifactName;
    private final String buildVersion;
    private final String buildFile;

    DepositoryPath(String groupName, String artifactName, String buildVersion, String buildFile) {
        this.groupName = groupName;
        this.artifactName = artifactName;
        this.buildVersion = buildVersion;
        this.buildFile = buildFile;
    }

    DepositoryPath(String groupName, String artifactName, String buildVersion) {
        this(groupName, artifactName, buildVersion, null);
    }

    DepositoryPath(String groupName, String artifactName) {
        this(groupName, artifactName, null, null);
    }

    DepositoryPath(String groupName) {
        this(groupName, null, null, null);
    }

    public DepositoryPath() {
        this(null, null, null, null);
    }

    public String[] toArray() {
        return new String[] { groupName, artifactName, buildVersion, buildFile };
    }

    public String getBuildFile() {
        return buildFile;
    }

    public String getBuildVersion() {
        return buildVersion;
    }

    public String getArtifactName() {
        return artifactName;
    }

    public String getGroupName() {
        return groupName;
    }

    public static DepositoryPath ofSystemPath(String path) {
        int buildNameIndex = path.lastIndexOf(File.separator);
        int buildVersionIndex = StringsUtils.lastIndexOf(path, File.separator, buildNameIndex);
        int artifactNameIndex = StringsUtils.lastIndexOf(path, File.separator, buildVersionIndex);

        String groupName = path.substring(1, artifactNameIndex).replace(File.separator, ".");
        String artifactName = path.substring(artifactNameIndex + 1, buildVersionIndex);
        String buildVersion = path.substring(buildVersionIndex + 1, buildNameIndex);
        String buildFile = path.substring(buildNameIndex + 1);

        return new DepositoryPath(groupName, artifactName, buildVersion, buildFile);
    }

}
