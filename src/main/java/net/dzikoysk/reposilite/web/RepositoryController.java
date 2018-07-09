package net.dzikoysk.reposilite.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class RepositoryController {

    @RequestMapping("/repository/**")
    @ResponseBody
    public String repository() {
        return "#TODO";
    }

}
