package org.panda_lang.reposilite.user.role;

import org.springframework.data.mongodb.repository.MongoRepository;

interface RoleRepository extends MongoRepository<Role, String> {

}
