package org.panda_lang.reposilite.auth;

import org.panda_lang.reposilite.user.User;
import org.panda_lang.reposilite.user.UserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class AuthenticationController {

    private final AuthenticationManager authenticationManager;

    @Autowired
    public AuthenticationController(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    @PostMapping("/api/authenticate")
    public ResponseEntity<?> login(@RequestBody Map<Object, String> parameters) {
        String username = parameters.get("username");
        String password = parameters.get("password");

        if (parameters.size() != 2 || username == null || password == null) {
            return ResponseEntity.badRequest().build();
        }

        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(username, password);
        Authentication authentication = this.authenticationManager.authenticate(authenticationToken);

        if (authentication == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

        User user = ((UserDetails) authentication.getPrincipal()).getUser();
        return ResponseEntity.ok(user);
    }

}
