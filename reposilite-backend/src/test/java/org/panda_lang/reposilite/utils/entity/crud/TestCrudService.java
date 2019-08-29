package org.panda_lang.reposilite.utils.entity.crud;

import java.util.List;
import java.util.Optional;
import org.bson.types.ObjectId;
import org.panda_lang.reposilite.utils.entity.CrudOperationsService;
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