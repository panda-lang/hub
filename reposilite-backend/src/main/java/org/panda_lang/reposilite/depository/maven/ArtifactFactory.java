package org.panda_lang.reposilite.depository.maven;

public final class ArtifactFactory {

    private final Group group;

    public ArtifactFactory(Group group) {
        this.group = group;
    }

    public Artifact obtainArtifact(String artifactName) {
        Artifact artifact = group.getArtifact(artifactName);

        if (artifact == null) {
            artifact = new Artifact(artifactName);
            group.addEntity(artifact);
        }

        return artifact;
    }

}
