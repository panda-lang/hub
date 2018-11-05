package net.dzikoysk.reposilite.depository.artifact;

import net.dzikoysk.reposilite.depository.group.Group;

public class ArtifactFactory {

    private final Group group;

    public ArtifactFactory(Group group) {
        this.group = group;
    }

    public Artifact obtainArtifact(String artifactName) {
        Artifact artifact = group.getArtifact(artifactName);

        if (artifact == null) {
            artifact = new Artifact(artifactName);
            group.addArtifact(artifact);
        }

        return artifact;
    }

}
