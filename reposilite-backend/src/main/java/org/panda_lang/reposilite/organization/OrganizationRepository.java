package org.panda_lang.reposilite.organization;

import org.bson.types.ObjectId;
import org.panda_lang.reposilite.utils.rest.NameableMongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface OrganizationRepository extends NameableMongoRepository<Organization, ObjectId> {

}
