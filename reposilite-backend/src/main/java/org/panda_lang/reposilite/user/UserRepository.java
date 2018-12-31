package org.panda_lang.reposilite.user;

import org.bson.types.ObjectId;
import org.panda_lang.reposilite.utils.NameableMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends NameableMongoRepository<User, ObjectId> {

}
