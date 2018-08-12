package net.dzikoysk.reposilite.domain.depository.entities.artifact;

import net.dzikoysk.reposilite.domain.depository.entities.AbstractDepositoryEntity;
import net.dzikoysk.reposilite.domain.depository.entities.build.Build;
import org.springframework.lang.Nullable;

import java.util.*;
import java.util.stream.Collectors;

public class Artifact extends AbstractDepositoryEntity {

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

    public List<? extends String> getVersions() {
        return builds.values().stream()
                .map(Build::getVersion)
                .sorted()
                .collect(Collectors.toList());
    }

    public Collection<? extends Build> getBuilds() {
        return Collections.unmodifiableCollection(builds.values());
    }

    @Override
    public String getName() {
        return name;
    }

}
