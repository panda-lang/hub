package org.panda_lang.reposilite.depository.maven;

import org.panda_lang.panda.utilities.commons.StringUtils;
import org.panda_lang.panda.utilities.commons.text.ContentJoiner;
import org.panda_lang.reposilite.utils.StringsUtils;

import java.io.File;

public final class MavenMetadata {

    private final String groupName;
    private final String artifactName;
    private final String buildVersion;
    private final String buildFile;

    MavenMetadata(String groupName, String artifactName, String buildVersion, String buildFile) {
        this.groupName = groupName;
        this.artifactName = artifactName;
        this.buildVersion = buildVersion;
        this.buildFile = buildFile;
    }

    public String getBuildFile() {
        return this.buildFile;
    }

    public String getBuildVersion() {
        return this.buildVersion;
    }

    public String getArtifactName() {
        return this.artifactName;
    }

    public String getGroupName() {
        return this.groupName;
    }

    public String getURI(String separator) {
        return ContentJoiner.on(separator)
                .join(StringUtils.replace(groupName, ".", separator), artifactName, buildVersion, buildFile)
                .toString();
    }

    static MavenMetadata ofSystemPath(String path) {
        int buildNameIndex = path.lastIndexOf(File.separator);
        int buildVersionIndex = StringsUtils.lastIndexOf(path, File.separator, buildNameIndex);
        int artifactNameIndex = StringsUtils.lastIndexOf(path, File.separator, buildVersionIndex);

        String groupName = path.substring(1, artifactNameIndex).replace(File.separator, ".");
        String artifactName = path.substring(artifactNameIndex + 1, buildVersionIndex);
        String buildVersion = path.substring(buildVersionIndex + 1, buildNameIndex);
        String buildFile = path.substring(buildNameIndex + 1);

        return new MavenMetadata(groupName, artifactName, buildVersion, buildFile);
    }

}
