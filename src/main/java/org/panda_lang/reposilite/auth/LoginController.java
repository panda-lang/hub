package org.panda_lang.reposilite.auth;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

// TODO
@Controller
public class LoginController {

    @RequestMapping("/login")
    public String profile() {
        return "Login";
    }


}
