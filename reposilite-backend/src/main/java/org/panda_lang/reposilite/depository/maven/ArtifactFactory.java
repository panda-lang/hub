package org.panda_lang.reposilite.depository.maven;

final class ArtifactFactory {

    private final Group group;

    ArtifactFactory(Group group) {
        this.group = group;
    }

    protected Artifact obtainArtifact(String artifactName) {
        Artifact artifact = group.getArtifact(artifactName);

        if (artifact == null) {
            artifact = new Artifact(artifactName);
            group.addEntity(artifact);
        }

        return artifact;
    }

}
