package org.panda_lang.reposilite.user;

import io.swagger.annotations.ApiOperation;
import org.bson.types.ObjectId;
import org.panda_lang.reposilite.utils.AbstractCrudController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@ApiOperation("Operations pertaining to user")
@RestController
@RequestMapping("api/user/")
public class UserController extends AbstractCrudController<User, ObjectId, UserUpdateDto, UserRegistrationDto> {

    protected UserController(@Autowired UserCrudService service) {
        super(service);
    }

}
