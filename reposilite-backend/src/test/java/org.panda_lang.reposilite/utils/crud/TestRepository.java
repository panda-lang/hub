package org.panda_lang.reposilite.utils.crud;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TestRepository extends MongoRepository<TestEntity, ObjectId> {

  Optional<TestEntity> findByUsername(String username);

}