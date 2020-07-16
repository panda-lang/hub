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

import org.panda_lang.hub.utils.Buildable;

import java.util.Set;

final class MetadataFileBuilder implements Buildable<MetadataFile> {

    private String groupId;
    private String artifactId;
    private String release;
    private String latest;
    private long lastUpdated;
    private Set<String> versions;

    public MetadataFileBuilder withGroupId(String groupId) {
        this.groupId = groupId;
        return this;
    }

    public MetadataFileBuilder withArtifactId(String artifactId) {
        this.artifactId = artifactId;
        return this;
    }

    public MetadataFileBuilder withRelease(String release) {
        this.release = release;
        return this;
    }

    public MetadataFileBuilder withLatest(String latest) {
        this.latest = latest;
        return this;
    }

    public MetadataFileBuilder withLastUpdated(long lastUpdated) {
        this.lastUpdated = lastUpdated;
        return this;
    }

    public MetadataFileBuilder withVersions(Set<String> versions) {
        this.versions = versions;
        return this;
    }

    @Override
    public MetadataFile build() {
        return new MetadataFile(
                this.groupId,
                this.artifactId,
                new MetadataFile.Versioning(
                        this.release,
                        this.latest,
                        new MetadataFile.Versions(this.versions),
                        this.lastUpdated
                )
        );
    }

}
