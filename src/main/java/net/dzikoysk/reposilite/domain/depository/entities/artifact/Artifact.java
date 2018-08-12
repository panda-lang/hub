package net.dzikoysk.reposilite.domain.depository.entities.artifact;

import net.dzikoysk.reposilite.domain.depository.entities.AbstractDepositoryEntity;
import net.dzikoysk.reposilite.domain.depository.entities.build.Build;
import org.springframework.lang.Nullable;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class Artifact extends AbstractDepositoryEntity {

    Artifact(String name) {
        super(name);
    }

    public void addBuild(Build build) {
        super.addElement(build);
    }

    public List<? extends String> getVersions() {
        return super.streamOfType(Build.class)
                .map(Build::getName)
                .sorted()
                .collect(Collectors.toList());
    }

    public @Nullable Build getBuild(String version) {
        return super.getMappedChildrenOfType(Build.class).get(version);
    }

    public Collection<? extends Build> getBuilds() {
        return super.getChildrenOfType(Build.class);
    }

}
