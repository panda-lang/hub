package org.panda_lang.reposilite.auth;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.panda_lang.reposilite.user.User;
import org.panda_lang.reposilite.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Optional;

@ApiOperation("Operations pertaining to registration")
@RestController
@RequestMapping("api/registration")
public class RegistrationController {

    private final UserService userService;

    @Autowired
    public RegistrationController(UserService userService) {
        this.userService = userService;
    }

    @ApiOperation(value = "Register a user account")
    @ApiResponses({
            @ApiResponse(code = 409, message = "User with that username already exists"),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 201, message = "Successfully created user", response = User.class)
    })
    @PostMapping
    public ResponseEntity<User> register(@Valid RegistrationForm form, BindingResult result) {
        Optional<User> user = this.userService.findByUsername(form.getUsername());

        if (user.isPresent()) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }

        if (result.hasErrors()) {
            return ResponseEntity.badRequest().build();
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(this.userService.saveByForm(form));
    }

}
