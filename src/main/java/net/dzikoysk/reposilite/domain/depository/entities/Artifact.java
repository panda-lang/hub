package net.dzikoysk.reposilite.domain.depository.entities;

import net.dzikoysk.reposilite.domain.depository.DepositoryEntity;
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

    public void setName(String name) {
        this.name = name;
    }

    public Collection<Build> getBuilds() {
        return Collections.unmodifiableCollection(builds);
    }

    public void addBuild(Build build) {
        builds.add(build);
    }

    public void removeBuild(Build build) {
        //TODO: Delete build content?
        builds.remove(build);
    }

    public void clearBuilds() {
        //TODO: Probably uncomment if builds content are gonna be deleted.
        //for (Build build : builds) {
        //    removeBuild(build);
        //}
        builds.clear();
    }

    public @Nullable Build findBuildByVersion(String version) {
        return builds.stream()
                .filter(build -> build.getVersion().equals(version))
                .findFirst()
                .orElse(null);
    }

    public @Nullable Build findBuildByContent(File file) {
        return null;
    }

}
