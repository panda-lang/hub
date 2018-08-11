package net.dzikoysk.reposilite.domain.depository.entities;

import org.springframework.lang.Nullable;

import java.util.HashMap;
import java.util.Map;

public class Group {

    private final String groupName;
    private final Map<String, Artifact> artifacts;

    Group(String groupName) {
        this.groupName = groupName;
        this.artifacts = new HashMap<>();
    }

    public void addArtifact(Artifact artifact) {
        artifacts.put(artifact.getName(), artifact);
    }

    public @Nullable Artifact getArtifact(String artifactName) {
        return artifacts.get(artifactName);
    }

    public String getName() {
        return groupName;
    }

}
