package org.panda_lang.reposilite.auth;

import org.panda_lang.reposilite.user.User;
import org.panda_lang.reposilite.user.UserAuthenticationDto;
import org.panda_lang.reposilite.user.UserDetails;
import org.panda_lang.reposilite.utils.RequestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class AuthenticationController {

    private final AuthenticationManager authenticationManager;

    @Autowired
    public AuthenticationController(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    @PostMapping("/api/authenticate")
    public ResponseEntity<?> login(@RequestBody @Valid UserAuthenticationDto dto, BindingResult result) {
        if (result.hasErrors()) {
            return RequestUtils.validationError(result);
        }

        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(dto.getUsername(), dto.getPassword());
        Authentication authentication = this.authenticationManager.authenticate(authenticationToken);

        if (authentication == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

        User user = ((UserDetails) authentication.getPrincipal()).getUser();
        return ResponseEntity.ok(user);
    }

}
