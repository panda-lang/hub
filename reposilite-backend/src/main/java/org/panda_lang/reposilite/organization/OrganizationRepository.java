package org.panda_lang.reposilite.organization;

import org.bson.types.ObjectId;
import org.panda_lang.reposilite.utils.entity.NameableMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
interface OrganizationRepository extends NameableMongoRepository<Organization, ObjectId> {

}
