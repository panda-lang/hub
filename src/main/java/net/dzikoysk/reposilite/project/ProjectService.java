package net.dzikoysk.reposilite.project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectService {

    private final ProjectRepository projectRepository;

    public ProjectService(@Autowired ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

}
