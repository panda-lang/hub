package org.panda_lang.reposilite.user;

import org.bson.types.ObjectId;
import org.panda_lang.reposilite.utils.CrudOperationsService;

public interface UserCrudService extends CrudOperationsService<User, ObjectId> {

    User save(User user);

}
