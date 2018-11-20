package org.panda_lang.reposilite.organization;

import org.bson.types.ObjectId;
import org.panda_lang.reposilite.user.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OrganizationRepository extends MongoRepository<Organization, ObjectId> {

    Optional<Organization> findByOwner(User owner);

}
