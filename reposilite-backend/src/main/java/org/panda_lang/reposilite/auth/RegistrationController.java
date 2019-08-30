package org.panda_lang.reposilite.auth;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.panda_lang.reposilite.user.User;
import org.panda_lang.reposilite.user.UserRegistrationDto;
import org.panda_lang.reposilite.user.UserCrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Optional;

@ApiOperation("Operations pertaining to registration")
@RestController
@RequestMapping("api/register")
final class RegistrationController {

    private final UserCrudService service;

    @Autowired
    public RegistrationController(UserCrudService service) {
        this.service = service;
    }

    @ApiOperation(value = "Register a user account")
    @ApiResponses({
            @ApiResponse(code = 409, message = "User with that username already exists"),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 201, message = "Successfully created user", response = User.class)
    })
    @PostMapping
    public ResponseEntity<?> register(@Valid @RequestBody UserRegistrationDto dto, BindingResult result) {
        Optional<User> user = this.service.findByName(dto.getUsername());

        if (user.isPresent()) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }

        if (result.hasErrors()) {
            return ResponseEntity.badRequest().build();
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(this.service.save(dto.toEntity()));
    }

}
