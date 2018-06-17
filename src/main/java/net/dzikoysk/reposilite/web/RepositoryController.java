package net.dzikoysk.reposilite.web;

import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

@Controller
public class RepositoryController {

    @RequestMapping("/repository/**")
    @ResponseBody
    public String repository() {
        return "#TODO";
    }

}
