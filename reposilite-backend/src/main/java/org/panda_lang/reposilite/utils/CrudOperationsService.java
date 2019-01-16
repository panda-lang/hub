package org.panda_lang.reposilite.utils;

import java.util.List;
import java.util.Optional;

public interface CrudOperationsService<T extends IdentifiableEntity<ID>, ID> {

  Optional<T> findByName(String name);

  Optional<T> findById(ID id);

  List<T> findAll();

  <S extends T> S save(S entity);

  void deleteById(ID id);

  boolean existsById(ID id);

}
