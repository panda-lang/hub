package org.panda_lang.reposilite.utils;

import org.bson.types.ObjectId;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.panda_lang.reposilite.utils.entity.crud.TestEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@RunWith(SpringRunner.class)
class BeanUtilTest {

  @Test
  void copyNonNullProperties() {
    ObjectId id = ObjectId.get();

    TestEntity testEntity = new TestEntity(id, "testUsername", "something fucked up");
    TestEntity testEntityEdited = new TestEntity(null, "testUsernameButEdited", null);

    BeanUtil.copyNonNullProperties(testEntity, testEntityEdited);

    assertAll(
        () -> assertNotNull(testEntity),
        () -> assertNotNull(testEntityEdited),
        () -> assertEquals(testEntityEdited.getUsername(), testEntity.getUsername()),
        () -> assertEquals(testEntityEdited.getIdentifier(), testEntity.getIdentifier()),
        () -> assertEquals(testEntityEdited.getSomething(), testEntity.getSomething())
    );
  }

}
