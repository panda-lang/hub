package org.panda_lang.reposilite.user;

import io.swagger.annotations.ApiOperation;
import org.panda_lang.reposilite.utils.AbstractCrudRestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@ApiOperation("Operations pertaining to user")
@RestController
@RequestMapping("api/user/")
public class AbstractCrudRestControllerIntegrationTest extends AbstractCrudRestController<User> {

    @Autowired
    public AbstractCrudRestControllerIntegrationTest(UserRepository userRepository) {
        super(userRepository);
    }

}
