package org.panda_lang.reposilite.builtin;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static j2html.TagCreator.a;
import static j2html.TagCreator.body;
import static j2html.TagCreator.h2;
import static j2html.TagCreator.li;
import static j2html.TagCreator.p;
import static j2html.TagCreator.ul;

@RestController
@ConditionalOnProperty(
        value = "reposilite.built-in-frontend",
        havingValue = "on"
)
class BuiltInIndexController {

    @RequestMapping("/")
    protected String index() {
        return BuiltInLayout.content("Home", body(
                h2("Reposilite"),
                p("Repository management software mainly dedicated for Maven and Panda-based artifacts"),
                ul(
                        li(a("Repositories").withHref("/repositories")),
                        li(a("Contribute").withHref("https://github.com/panda-lang/reposilite"))
                )
        ));
    }

}
