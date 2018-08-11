package net.dzikoysk.reposilite.domain.depository.entities;

import net.dzikoysk.reposilite.domain.depository.DepositoryEntity;
import org.springframework.lang.Nullable;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Artifact implements DepositoryEntity {

    private final String name;
    private final Map<String, Build> builds;

    Artifact(String name) {
        this.name = name;
        this.builds = new HashMap<>();
    }

    public void addBuild(Build build) {
        builds.put(build.getVersion(), build);
    }

    public void removeBuild(Build build) {
        //TODO: Delete build content?
        builds.remove(build.getVersion());
    }

    public void clearBuilds() {
        //TODO: Probably uncomment if builds content are gonna be deleted.
        //for (Build build : builds) {
        //    removeBuild(build);
        //}
        builds.clear();
    }

    public @Nullable Build getBuildByVersion(String version) {
        return builds.values().stream()
                .filter(build -> build.getVersion().equals(version))
                .findFirst()
                .orElse(null);
    }

    public @Nullable Build getBuild(String version) {
        return builds.get(version);
    }

    public Collection<? extends Build> getBuilds() {
        return Collections.unmodifiableCollection(builds.values());
    }

    public String getName() {
        return name;
    }

}
