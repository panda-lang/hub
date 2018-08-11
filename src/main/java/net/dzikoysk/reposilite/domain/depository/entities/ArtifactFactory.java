package net.dzikoysk.reposilite.domain.depository.entities;

public class ArtifactFactory {

    private final Group group;

    public ArtifactFactory(Group group) {
        this.group = group;
    }

    public Artifact obtainArtifact(String artifactName) {
        return group.getArtifact(artifactName) != null ? group.getArtifact(artifactName) : new Artifact(artifactName);
    }

    public Build obtainBuild(Artifact artifact, String buildVersion) {
        Build build = artifact.getBuild(buildVersion);

        if (build == null) {
            build = new Build(buildVersion);
        }

        return build;
    }

}
