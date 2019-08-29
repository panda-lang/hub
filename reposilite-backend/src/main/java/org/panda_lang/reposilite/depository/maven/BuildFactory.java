package org.panda_lang.reposilite.depository.maven;

final class BuildFactory {

    private final Artifact artifact;

    BuildFactory(Artifact artifact) {
        this.artifact = artifact;
    }

    protected Build obtainBuild(String buildVersion) {
        Build build = artifact.getBuild(buildVersion);

        if (build == null) {
            build = new Build(buildVersion);
            artifact.addEntity(build);
        }

        return build;
    }

}
