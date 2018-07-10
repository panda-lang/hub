package net.dzikoysk.reposilite.web;

import net.dzikoysk.reposilite.domain.depository.DepositoryEntity;
import net.dzikoysk.reposilite.domain.depository.entities.Artifact;
import net.dzikoysk.reposilite.service.common.UserService;
import net.dzikoysk.reposilite.service.depository.DepositoryService;
import net.dzikoysk.reposilite.utils.RequestUtils;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("/repository")
@Controller
public class RepositoryController {

    private final AntPathMatcher antMatcher = new AntPathMatcher();

    private final DepositoryService depositoryService;
    private final UserService userService;

    @Autowired
    public RepositoryController(DepositoryService depositoryService, UserService userService) {
        this.depositoryService = depositoryService;
        this.userService = userService;
    }

    @RequestMapping
    @ResponseBody
    public String repositories() {
        //TODO: Return only public repositories and hidden ones as well if user is logged in and have permission to them.

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

        String entityQualifier = RequestUtils.extractWildcard(antMatcher, request);
        DepositoryEntity entity = depositoryService.getDepositoryEntity(entityQualifier);

        if (entity == null) {
            //TODO: Entity (artifact) not found, perhaps display some 404 page?
            return "Artifact '" + entityQualifier + "' not found";
        }

        if (!(entity instanceof Artifact)) {
            //TODO: Repository should have artifacts only?
            return "Artifact: not artifact";
        }

        return "Artifact: " + entity;
    }

}
