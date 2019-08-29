package org.panda_lang.reposilite.depository.maven;

import org.panda_lang.reposilite.depository.AbstractDepositoryEntity;
import org.springframework.lang.Nullable;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public final class Artifact extends AbstractDepositoryEntity {

    Artifact(String name) {
        super(name);
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
