package org.panda_lang.reposilite.utils.entity;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.Optional;

@NoRepositoryBean
public interface NameableMongoRepository<T extends IdentifiableEntity<ID>, ID> extends MongoRepository<T, ID> {

    Optional<T> findByName(String name);

    boolean existsByName(String name);

}
