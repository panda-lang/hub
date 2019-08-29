package org.panda_lang.reposilite.builtin;

import org.panda_lang.reposilite.depository.DepositoryEntity;
import org.panda_lang.reposilite.depository.DepositoryNotFoundException;
import org.panda_lang.reposilite.depository.DepositoryService;
import org.panda_lang.reposilite.depository.DepositorySubService;
import org.panda_lang.reposilite.depository.maven.Data;
import org.panda_lang.reposilite.utils.RequestUtils;
import org.panda_lang.reposilite.utils.ResponseUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Comparator;
import java.util.Optional;

import static j2html.TagCreator.a;
import static j2html.TagCreator.body;
import static j2html.TagCreator.each;
import static j2html.TagCreator.h2;
import static j2html.TagCreator.li;
import static j2html.TagCreator.p;
import static j2html.TagCreator.ul;

@RestController
@ConditionalOnProperty(
        value = "reposilite.built-in-frontend",
        havingValue = "on"
)
class BuiltInDepositoryController {

    private final DepositoryService depositoryService;

    @Autowired
    public BuiltInDepositoryController(DepositoryService depositoryService) {
        this.depositoryService = depositoryService;
    }

    @RequestMapping(path = { "/repositories", "/repository" })
    protected ResponseEntity<String> repositories() {
        return ResponseEntity.ok(BuiltInLayout.content("Repositories", body(
                h2("Reposilite Repositories"),
                ul(
                        li(a("panda").withHref("/repository/panda")),
                        li(a("maven").withHref("/repository/maven")),
                        li(a("npm").withHref("/repository/npm"))
                )
        )));
    }

    @RequestMapping("/repository/{name}")
    protected ResponseEntity<String> repository(@PathVariable("name") String name) {
        Optional<DepositorySubService> subService = depositoryService.getSubService(name);

        if (!subService.isPresent()) {
            throw new DepositoryNotFoundException();
        }

        String title = subService.get().getName() + " Repository";

        return ResponseEntity.ok(BuiltInLayout.content(title, body(
                h2(title),
                ul(
                        each(subService.get().getEntities().stream()
                                .sorted(Comparator.comparing(DepositoryEntity::getName))
                                .map(entity -> li(a(entity.getName()).withHref("/repository/" + name + "/" + entity.getName())))
                        )
                )
        )));
    }

    @RequestMapping("/repository/{name}/**")
    protected ResponseEntity<Object> repository(@PathVariable("name") String name, HttpServletRequest request, HttpServletResponse response) throws IOException {
        Optional<DepositorySubService> service = depositoryService.getSubService(name);

        if (!service.isPresent()) {
            throw new DepositoryNotFoundException();
        }

        String entityQualifier = RequestUtils.extractWildcard(request);
        Optional<DepositoryEntity> entityValue = service.get().findEntity(entityQualifier);

        if (!entityValue.isPresent()) {
            throw new DepositoryNotFoundException();
        }

        DepositoryEntity entity = entityValue.get();
        String url = "";

        if (entity instanceof Data) {
            return ResponseUtils.returnFile(response, "application/java", ((Data) entity).getFile());
        }

        String title = service.get().getName() + " Repository";

        return ResponseEntity.ok(BuiltInLayout.content(title, body(
                h2(title + " :: " + entityQualifier),
                ul(
                        each(entity.getChildren().stream()
                                .sorted(Comparator.comparing(DepositoryEntity::getURIName))
                                .map(element -> p(a(element.getName()).withHref("/repository/" + name + "/" + entityQualifier + "/" + element.getName())))
                        )
                )
        )));
    }

}
