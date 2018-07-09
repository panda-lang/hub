package net.dzikoysk.reposilite.web.repository;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.HandlerMapping;

@RequestMapping("/repository")
@Controller
public class RepositoryController {

    private final AntPathMatcher apm = new AntPathMatcher();

    @RequestMapping({ "", "/" })
    @ResponseBody
    public String repositories() {
        return "Repository list";
    }

    @RequestMapping({ "/{repository}", "/{repository}/" })
    @ResponseBody
    public String repository(@PathVariable("repository") String repository) {
        return "Repository name: " + repository;
    }

    @RequestMapping(value = "/{repository}/**")
    @ResponseBody
    public String repository(@PathVariable("repository") String repository, HttpServletRequest request) {
        String path = request.getAttribute(HandlerMapping.PATH_WITHIN_HANDLER_MAPPING_ATTRIBUTE).toString();
        String bestMatchingPattern = request.getAttribute(HandlerMapping.BEST_MATCHING_PATTERN_ATTRIBUTE).toString();
        String finalPath = apm.extractPathWithinPattern(bestMatchingPattern, path);

        return "Artifact: " + finalPath.replace("/", ".");
    }

}
