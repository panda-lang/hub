package net.dzikoysk.reposilite.web;

import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Controller
public class HomeController {

    @RequestMapping(value = "/")
    public String home(Model model) {
        model.addAttribute("time", new Date());
        model.addAttribute("message", "#TODO");
        model.addAttribute("title", "Reposilite");
        return "home";
    }

}
