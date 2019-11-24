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

package org.panda_lang.reposilite.resource.maven;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.Collection;

@XmlRootElement(name = "metadata")
@XmlAccessorType(XmlAccessType.FIELD)
final class MetadataFile implements Serializable {

    private String groupId;
    private String artifactId;
    private Versioning versioning;

    protected MetadataFile() { }

    protected MetadataFile(String groupId, String artifactId, Versioning versioning) {
        this.groupId = groupId;
        this.artifactId = artifactId;
        this.versioning = versioning;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public void setArtifactId(String artifactId) {
        this.artifactId = artifactId;
    }

    public void setVersioning(Versioning versioning) {
        this.versioning = versioning;
    }

    public String getGroupId() {
        return this.groupId;
    }

    public String getArtifactId() {
        return this.artifactId;
    }

    public Versioning getVersioning() {
        return this.versioning;
    }

    @XmlRootElement(name = "versioning")
    @XmlAccessorType(XmlAccessType.FIELD)
    public static class Versioning {

        private String release;
        private String latest;
        private Versions versions;
        private long lastUpdated;

        Versioning() {
        }

        Versioning(String release, String latest, Versions versions, long lastUpdated) {
            this.release = release;
            this.latest = latest;
            this.versions = versions;
            this.lastUpdated = lastUpdated;
        }

        public void setRelease(String release) {
            this.release = release;
        }

        public void setLatest(String latest) {
            this.latest = latest;
        }

        public void setVersions(Versions versions) {
            this.versions = versions;
        }

        public void setLastUpdated(long lastUpdated) {
            this.lastUpdated = lastUpdated;
        }

        public String getRelease() {
            return this.release;
        }

        public String getLatest() {
            return this.latest;
        }

        public Versions getVersions() {
            return this.versions;
        }

        public long getLastUpdated() {
            return this.lastUpdated;
        }

        @Override
        public String toString() {
            return "Versioning{" +
                    "release='" + this.release + '\'' +
                    ", latest='" + this.latest + '\'' +
                    ", versions=" + this.versions +
                    ", lastUpdated=" + this.lastUpdated +
                    '}';
        }
    }

    @XmlRootElement
    @XmlAccessorType(XmlAccessType.FIELD)
    public static class Versions {

        private Collection<String> version;

        Versions() {
        }

        Versions(Collection<String> version) {
            this.version = version;
        }

        public Collection<String> getVersion() {
            return this.version;
        }

        public void setVersion(Collection<String> version) {
            this.version = version;
        }

        @Override
        public String toString() {
            return "Versions{" +
                    "version=" + this.version +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "MavenMetadataFile{" +
                "groupId='" + this.groupId + '\'' +
                ", artifactId='" + this.artifactId + '\'' +
                ", versioning=" + this.versioning +
                '}';
    }

}
