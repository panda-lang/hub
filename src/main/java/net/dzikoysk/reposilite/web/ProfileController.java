package net.dzikoysk.reposilite.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/{account}")
public class ProfileController {

    @ResponseBody
    @RequestMapping
    public String profile(@PathVariable String account) {
        return "Profile: " + account;
    }

    @RequestMapping("/{project}")
    @ResponseBody
    public String project(@PathVariable String account, @PathVariable String project) {
        return "Profile: " + account + " - Project: " + project;
    }

}
