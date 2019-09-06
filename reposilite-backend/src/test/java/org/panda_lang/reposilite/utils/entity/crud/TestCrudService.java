/*
 * Copyright (c) 2018-2019 Reposilite Team
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

package org.panda_lang.reposilite.utils.entity.crud;

import org.bson.types.ObjectId;
import org.panda_lang.reposilite.utils.entity.CrudOperationsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TestCrudService implements CrudOperationsService<TestEntity, ObjectId> {

    TestRepository testRepository;

    @Autowired
    TestCrudService(TestRepository testRepository) {
        this.testRepository = testRepository;
    }

    @Override
    public Optional<TestEntity> findByName(String name) {
        return this.testRepository.findByUsername(name);
    }

    @Override
    public Optional<TestEntity> findById(ObjectId objectId) {
        return this.testRepository.findById(objectId);
    }

    @Override
    public List<TestEntity> findAll() {
        return this.testRepository.findAll();
    }

    @Override
    public <S extends TestEntity> S save(S entity) {
        return this.testRepository.save(entity);
    }

    @Override
    public void deleteById(ObjectId objectId) {
        this.testRepository.deleteById(objectId);
    }

    @Override
    public boolean existsById(ObjectId objectId) {
        return this.testRepository.existsById(objectId);
    }

}