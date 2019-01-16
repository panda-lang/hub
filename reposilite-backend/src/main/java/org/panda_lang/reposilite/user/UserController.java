package org.panda_lang.reposilite.user;

import io.swagger.annotations.ApiOperation;
import org.bson.types.ObjectId;
import org.panda_lang.reposilite.utils.AbstractCrudController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@ApiOperation("Operations pertaining to user")
@RestController
@RequestMapping("/api/users")
public class UserController extends AbstractCrudController<User, ObjectId, UserUpdateDto, UserRegistrationDto> {

    protected UserController(@Autowired UserCrudService service) {
        super(service);
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/me")
    public ResponseEntity<User> me(@AuthenticatedUser User user) {
        return ResponseEntity.ok(user);
    }

}
