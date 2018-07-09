package net.dzikoysk.reposilite.web;

import net.dzikoysk.reposilite.domain.depository.Artifact;
import net.dzikoysk.reposilite.domain.depository.DepositoryEntity;
import net.dzikoysk.reposilite.service.depository.ArtifactService;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.HandlerMapping;

@RequestMapping("/repository")
@Controller
public class RepositoryController {

    private final ArtifactService artifactService;
    private final AntPathMatcher apm = new AntPathMatcher();

    public RepositoryController(@Autowired ArtifactService artifactService) {
        this.artifactService = artifactService;
    }

    @RequestMapping
    @ResponseBody
    public String repositories() {
        return "Repository list";
    }

    @RequestMapping("/{repository}")
    @ResponseBody
    public String repository(@PathVariable("repository") String repository) {
        return "Repository name: " + repository;
    }

    @RequestMapping("/{repository}/**")
    @ResponseBody
    public String repository(@PathVariable("repository") String repository, HttpServletRequest request) {
        String path = request.getAttribute(HandlerMapping.PATH_WITHIN_HANDLER_MAPPING_ATTRIBUTE).toString();
        String bestMatchingPattern = request.getAttribute(HandlerMapping.BEST_MATCHING_PATTERN_ATTRIBUTE).toString();
        String finalPath = this.apm.extractPathWithinPattern(bestMatchingPattern, path);

        DepositoryEntity entity = this.artifactService.getDepositoryEntity(finalPath);
        if (entity == null) {
            //TODO: Entity (artifact) not found, perhaps display some 404 page?
            return "Artifact: 404";
        }

        if (!(entity instanceof Artifact)) {
            //TODO: Repository should have artifacts only?
            return "Artifact: not artifact";
        }

        return "Artifact: " + entity;
    }

}
