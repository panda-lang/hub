package org.panda_lang.reposilite.depository.maven;

import org.panda_lang.reposilite.utils.Buildable;

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
