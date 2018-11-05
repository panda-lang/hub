package net.dzikoysk.reposilite.depository.build;

import net.dzikoysk.reposilite.depository.artifact.Artifact;

public class BuildFactory {

    private final Artifact artifact;

    public BuildFactory(Artifact artifact) {
        this.artifact = artifact;
    }

    public Build obtainBuild(String buildVersion) {
        Build build = artifact.getBuild(buildVersion);

        if (build == null) {
            build = new Build(buildVersion);
            artifact.addBuild(build);
        }

        return build;
    }

}
