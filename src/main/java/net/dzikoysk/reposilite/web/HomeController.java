package net.dzikoysk.reposilite.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;

@Controller
public class HomeController {

    @RequestMapping(value = "/")
    public String home(Model model) {
        ArrayList<String> list = new ArrayList<>();
        list.add("x");
        list.add("y");

        model.addAttribute("time", list);
        model.addAttribute("message", "#TODO");
        model.addAttribute("title", "Reposilite");

        return "home";
    }

}
