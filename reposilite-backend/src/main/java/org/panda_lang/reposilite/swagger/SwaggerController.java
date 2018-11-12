package org.panda_lang.reposilite.swagger;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import springfox.documentation.annotations.ApiIgnore;

@Profile("development")
@Controller
@ApiIgnore
public class SwaggerController {

    @GetMapping("/api/docs")
    public String apiDocs() {
        return "redirect:/v2/api-docs";
    }

    @GetMapping("/swagger")
    public String swagger() {
        return "redirect:/swagger-ui.html";
    }

}
