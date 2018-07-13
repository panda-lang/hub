package net.dzikoysk.reposilite.domain.depository.entities;

import net.dzikoysk.reposilite.domain.depository.DepositoryEntity;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

import java.io.File;
import java.util.Collection;
import java.util.Collections;

public class Artifact implements DepositoryEntity {

    private String name;
    private Collection<Build> builds;

    public String getName() {
        return name;
    }

    public void setName(@NonNull String name) {
        this.name = name;
    }

    public Collection<Build> getBuilds() {
        return Collections.unmodifiableCollection(builds);
    }

    public void addBuild(@NonNull Build build) {
        builds.add(build);
    }

    public void removeBuild(@NonNull Build build) {
        //TODO: Delete build content?
        builds.remove(build);
    }

    public void clearBuilds() {
        builds.clear();
    }

    public @Nullable Build findBuildByVersion(@NonNull String version) {
        return builds.stream()
                .filter(build -> build.getVersion().equals(version))
                .findFirst()
                .orElse(null);
    }

    public @Nullable Build findBuildByContent(@NonNull File file) {
        return null;
    }

}
