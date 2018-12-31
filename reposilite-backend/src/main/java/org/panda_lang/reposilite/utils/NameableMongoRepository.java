package org.panda_lang.reposilite.utils;

import org.panda_lang.reposilite.utils.IdentifiableEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.Map;
import java.util.Optional;

@NoRepositoryBean
public interface NameableMongoRepository<T extends IdentifiableEntity<ID>, ID> extends MongoRepository<T, ID> {

    Optional<T> findByName(String name);

    void deleteByName(String name);

    boolean existsByName(String name);

}
