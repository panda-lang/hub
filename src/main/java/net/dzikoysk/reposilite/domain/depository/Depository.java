package net.dzikoysk.reposilite.domain.depository;

import net.dzikoysk.reposilite.domain.depository.entities.Artifact;

import java.io.File;
import java.util.Map;

public class Depository {

    private final File root;
    private Map<String, Artifact> projects;

    Depository(File root) {
        this.root = root;
    }

    public void addProject(Artifact artifact) {
        projects.put(artifact.getName(), artifact);
    }

    public Map<? extends String, ? extends Artifact> getProjects() {
        return projects;
    }

    public String getName() {
        return root.getName();
    }

    public File getRootFile() {
        return root;
    }

}
