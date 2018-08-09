package net.dzikoysk.reposilite.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/{account}")
public class ProfileController {

    @ResponseBody
    public String profile(@PathVariable("account") String account) {
        return "Profile: " + account;
    }

    @RequestMapping("/{project}")
    @ResponseBody
    public String profile(@PathVariable("account") String account, @PathVariable("project") String project) {
        return "Profile: " + account + " - Project: " + project;
    }

}
