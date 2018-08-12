package net.dzikoysk.reposilite.domain.depository.entities.group;

import net.dzikoysk.reposilite.domain.depository.entities.AbstractDepositoryEntity;
import net.dzikoysk.reposilite.domain.depository.entities.artifact.Artifact;
import org.springframework.lang.Nullable;

import java.util.Collection;

public class Group extends AbstractDepositoryEntity {

    private final GroupUnit[] units;

    Group(GroupUnit... units) {
        super(GroupUtils.toString(units));

        if (units == null || units.length == 0) {
            throw new IllegalArgumentException("Group units are not specified");
        }

        this.units = units;
    }

    public void addArtifact(Artifact artifact) {
        addElement(artifact);
    }

    public @Nullable Artifact getArtifact(String artifactName) {
        return super.getMappedChildrenOfType(Artifact.class).get(artifactName);
    }

    public Collection<? extends Artifact> getArtifacts() {
        return super.getChildrenOfType(Artifact.class);
    }

    public GroupUnit[] getUnits() {
        return units;
    }

}
