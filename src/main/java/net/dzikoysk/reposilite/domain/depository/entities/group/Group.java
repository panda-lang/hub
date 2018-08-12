package net.dzikoysk.reposilite.domain.depository.entities.group;

import net.dzikoysk.reposilite.domain.depository.DepositoryEntity;
import net.dzikoysk.reposilite.domain.depository.entities.artifact.Artifact;
import org.panda_lang.panda.utilities.commons.redact.ContentJoiner;
import org.springframework.lang.Nullable;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Group implements DepositoryEntity {

    private final GroupUnit[] units;
    private final Map<String, Artifact> artifacts;

    Group(GroupUnit... units) {
        if (units == null || units.length == 0) {
            throw new IllegalArgumentException("Group units are not specified");
        }

        this.units = units;
        this.artifacts = new HashMap<>();
    }

    public void addArtifact(Artifact artifact) {
        artifacts.put(artifact.getName(), artifact);
    }

    public @Nullable Artifact getArtifact(String artifactName) {
        return artifacts.get(artifactName);
    }

    public Collection<? extends Artifact> getArtifacts() {
        return artifacts.values();
    }

    @Override
    public String getName() {
        return ContentJoiner.on(".").join(units, GroupUnit::getName).toString();
    }

}
