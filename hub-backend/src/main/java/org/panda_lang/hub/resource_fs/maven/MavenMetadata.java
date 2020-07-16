/*
 * Copyright (c) 2018-2019 Hub Team
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

package org.panda_lang.hub.resource_fs.maven;

import org.panda_lang.utilities.commons.StringUtils;
import org.panda_lang.utilities.commons.text.ContentJoiner;

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
        int buildVersionIndex = lastIndexOfSeparator(path, buildNameIndex);
        int artifactNameIndex = lastIndexOfSeparator(path, buildVersionIndex);

        String groupName = path.substring(1, artifactNameIndex).replace(File.separator, ".");
        String artifactName = path.substring(artifactNameIndex + 1, buildVersionIndex);
        String buildVersion = path.substring(buildVersionIndex + 1, buildNameIndex);
        String buildFile = path.substring(buildNameIndex + 1);

        return new MavenMetadata(groupName, artifactName, buildVersion, buildFile);
    }

    private static int lastIndexOfSeparator(String text, int toIndex) {
        return toIndex < 0 ? -1 : text.substring(0, toIndex).lastIndexOf(File.separator);
    }

}
