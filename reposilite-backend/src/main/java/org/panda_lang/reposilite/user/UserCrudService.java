package org.panda_lang.reposilite.user;

import org.bson.types.ObjectId;
import org.panda_lang.reposilite.utils.entity.CrudOperationsService;

public interface UserCrudService extends CrudOperationsService<User, ObjectId> {

    @Override
    @SuppressWarnings("unchecked")
    User save(User user);

}
