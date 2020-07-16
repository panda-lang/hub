/*
 * Copyright (c) 2018-2019 Hub Team
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.panda_lang.hub.utils.entity;

import java.util.List;
import java.util.Optional;

public abstract class AbstractCrudOperationService<R extends NameableMongoRepository<E, ID>, E extends IdentifiableEntity<ID>, ID> implements CrudOperationsService<E, ID> {

    private final R repository;

    protected AbstractCrudOperationService(R repository) {
        this.repository = repository;
    }

    @Override
    public Optional<E> findByName(String name) {
        return repository.findByName(name);
    }

    @Override
    public Optional<E> findById(ID id) {
        return repository.findById(id);
    }

    @Override
    public List<E> findAll() {
        return repository.findAll();
    }

    @Override
    public <S extends E> S save(S entity) {
        return repository.save(entity);
    }

    @Override
    public void deleteById(ID id) {
        repository.deleteById(id);
    }

    @Override
    public boolean existsById(ID id) {
        return repository.existsById(id);
    }

    protected R getRepository() {
        return repository;
    }

}
