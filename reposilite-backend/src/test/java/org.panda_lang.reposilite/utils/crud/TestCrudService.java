/*
 * MIT License
 *
 * Copyright (c) 2018 Coachy
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package org.panda_lang.reposilite.utils.crud;

import java.util.List;
import java.util.Optional;
import org.bson.types.ObjectId;
import org.panda_lang.reposilite.utils.CrudOperationsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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