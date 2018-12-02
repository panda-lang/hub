package org.panda_lang.reposilite.depository;

import org.panda_lang.reposilite.utils.Buildable;

import java.util.Set;

public class MavenMetadataFileBuilder implements Buildable<MavenMetadataFile> {

    private String groupId;
    private String artifactId;
    private String release;
    private String latest;
    private long lastUpdated;
    private Set<String> versions;

    public MavenMetadataFileBuilder withGroupId(String groupId) {
        this.groupId = groupId;
        return this;
    }

    public MavenMetadataFileBuilder withArtifactId(String artifactId) {
        this.artifactId = artifactId;
        return this;
    }

    public MavenMetadataFileBuilder withRelease(String release) {
        this.release = release;
        return this;
    }

    public MavenMetadataFileBuilder withLatest(String latest) {
        this.latest = latest;
        return this;
    }

    public MavenMetadataFileBuilder withLastUpdated(long lastUpdated) {
        this.lastUpdated = lastUpdated;
        return this;
    }

    public MavenMetadataFileBuilder withVersions(Set<String> versions) {
        this.versions = versions;
        return this;
    }

    @Override
    public MavenMetadataFile build() {
        return new MavenMetadataFile(
                this.groupId,
                this.artifactId,
                new MavenMetadataFile.Versioning(
                        this.release,
                        this.latest,
                        new MavenMetadataFile.Versions(this.versions),
                        this.lastUpdated
                )
        );
    }

}
