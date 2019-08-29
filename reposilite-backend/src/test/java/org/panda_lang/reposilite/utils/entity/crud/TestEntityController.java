package org.panda_lang.reposilite.utils.entity.crud;

import org.bson.types.ObjectId;
import org.panda_lang.reposilite.utils.entity.AbstractCrudController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/tests")
public class TestEntityController extends AbstractCrudController<TestEntity, ObjectId, TestDto, TestDto> {

  protected TestEntityController(@Autowired TestCrudService service) {
    super(service);
  }

}
