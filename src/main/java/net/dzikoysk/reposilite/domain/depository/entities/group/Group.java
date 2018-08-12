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

    public @Nullable GroupUnit matchGroupUnit(String partOfGroupName) {
        String[] elements = partOfGroupName.split("\\.");

        if (elements.length > units.length) {
            return null;
        }

        GroupUnit lastUnit = null;

        for (int i = 0; i < elements.length; i++) {
            GroupUnit currentUnit = units[i];

            if (!currentUnit.getName().equals(elements[i])) {
                return null;
            }

            lastUnit = currentUnit;
        }

        return lastUnit;
    }

    public void addArtifact(Artifact artifact) {
        super.addElement(artifact);
    }

    public @Nullable Artifact getArtifact(String artifactName) {
        return super.getMappedChildrenOfType(Artifact.class).get(artifactName);
    }

    public Collection<? extends Artifact> getArtifacts() {
        return super.getChildrenOfType(Artifact.class);
    }

}
