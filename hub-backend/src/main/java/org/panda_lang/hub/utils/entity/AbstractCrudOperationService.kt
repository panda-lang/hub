/*
 * Copyright (c) 2020 Hub Team of panda-lang organization
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
package org.panda_lang.hub.utils.entity

abstract class AbstractCrudOperationService<R : NameableMongoRepository<E, ID>, E : IdentifiableEntity<ID>, ID>(
    protected val repository: R
) : CrudOperationsService<E, ID> {

    override fun findByName(name: String): E? {
        return repository.findByName(name)
    }

    override fun findById(id: ID): E? {
        return repository.findByIdentifier(id)
    }

    override fun findAll(): List<E> {
        return repository.findAll()
    }

    override fun <S : E> save(entity: S): S {
        return repository.save(entity)
    }

    override fun deleteById(id: ID) {
        repository.deleteById(id)
    }

    override fun existsById(id: ID): Boolean {
        return repository.existsById(id)
    }
}
