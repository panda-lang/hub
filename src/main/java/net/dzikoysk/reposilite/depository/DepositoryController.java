package net.dzikoysk.reposilite.depository;

import net.dzikoysk.reposilite.depository.build.Data;
import net.dzikoysk.reposilite.user.UserService;
import net.dzikoysk.reposilite.utils.RequestUtils;
import org.panda_lang.panda.utilities.commons.IOUtils;
import org.panda_lang.panda.utilities.commons.StringUtils;
import org.panda_lang.panda.utilities.commons.text.ContentJoiner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RequestMapping("/repository")
@Controller
public class DepositoryController {

    private final DepositoryService depositoryService;
    private final UserService userService;

    @Autowired
    public DepositoryController(DepositoryService depositoryService, UserService userService) {
        this.depositoryService = depositoryService;
        this.userService = userService;
    }

    @RequestMapping
    @ResponseBody
    public String repositories() {
        //TODO: Return only public repositories and hidden ones as well if user is logged in and have permission to them.
        return "Repositories: <br>" + ContentJoiner.on("<br>").join(depositoryService.getNames());
    }

    @RequestMapping("/{repository}")
    @ResponseBody
    public String repository(@PathVariable String repository) {
        Depository depository = depositoryService.getDepository(repository);

        if (depository == null) {
            return "Repository '" + repository + "' not found";
        }

        return "Repository name: " + repository;
    }

    @RequestMapping("/{repository}/**")
    @ResponseBody
    public String repository(@PathVariable String repository, HttpServletRequest request, HttpServletResponse response) throws Exception {
        Depository depository = depositoryService.getDepository(repository);

        if (depository == null) {
            return "Repository '" + repository + "' not found";
        }

        String entityQualifier = RequestUtils.extractWildcard(request);
        DepositoryEntity entity = depositoryService.getDepositoryEntity(depository, entityQualifier);

        if (entity == null) {
            // TODO: Entity (artifact) not found, perhaps display some 404 page?
            return "Entity '" + entityQualifier + "' not found";
        }

        System.out.println("Entity: " + entity.getName() + " of " + entity.getClass());

        // TODO: Resource handler
        if (entity instanceof Data) {
            response.setContentType("application/java");
            response.addHeader("Content-Disposition", "attachment; filename=\"" + entity.getName() + "\"");
            return IOUtils.convertStreamToString(new FileSystemResource(((Data) entity).getFile()).getInputStream());
        }

        return StringUtils.EMPTY;
    }

}
