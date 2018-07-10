package net.dzikoysk.reposilite.web;

import net.dzikoysk.reposilite.domain.depository.Artifact;
import net.dzikoysk.reposilite.domain.depository.DepositoryEntity;
import net.dzikoysk.reposilite.service.common.UserService;
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
    private final UserService userService;
    private final AntPathMatcher apm = new AntPathMatcher();

    public RepositoryController(@Autowired ArtifactService artifactService, @Autowired UserService userService) {
        this.artifactService = artifactService;
        this.userService = userService;
    }

    @RequestMapping
    @ResponseBody
    public String repositories() {
        //TODO: Return only public repositories and hidden ones as well if user is logged and have permission to them.

        return "Repository list";
    }

    @RequestMapping("/{repository}")
    @ResponseBody
    public String repository(@PathVariable("repository") String repository) {
        //TODO: Make sure repository exists.

        return "Repository name: " + repository;
    }

    @RequestMapping("/{repository}/**")
    @ResponseBody
    public String repository(@PathVariable("repository") String repository, HttpServletRequest request) {
        //TODO: Make sure repository exists.

        String path = request.getAttribute(HandlerMapping.PATH_WITHIN_HANDLER_MAPPING_ATTRIBUTE).toString();
        String bestMatchingPattern = request.getAttribute(HandlerMapping.BEST_MATCHING_PATTERN_ATTRIBUTE).toString();
        String finalPath = apm.extractPathWithinPattern(bestMatchingPattern, path);

        DepositoryEntity entity = artifactService.getDepositoryEntity(finalPath);
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
