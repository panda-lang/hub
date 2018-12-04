package org.panda_lang.reposilite.depository.maven;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.Collection;

@XmlRootElement(name = "metadata")
@XmlAccessorType(XmlAccessType.FIELD)
class MavenMetadataFile implements Serializable {

    private String groupId;
    private String artifactId;
    private Versioning versioning;

    MavenMetadataFile() {
    }

    MavenMetadataFile(String groupId, String artifactId, Versioning versioning) {
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

    }

}
