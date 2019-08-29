package org.panda_lang.reposilite.utils.entity.crud;

import org.panda_lang.reposilite.utils.entity.AbstractDto;

import javax.validation.constraints.NotEmpty;

public class TestDto extends AbstractDto<TestEntity> {

  @NotEmpty
  private String username;

  @NotEmpty
  private String something;

  public TestDto(String username, String something) {
    this.username = username;
    this.something = something;
  }

  public TestDto() { // JACKSON
  }

  public String getUsername() {
    return this.username;
  }

  public String getSomething() {
    return this.something;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public void setSomething(String something) {
    this.something = something;
  }

  @Override
  public String getName() {
    return this.username;
  }

  public TestEntity toEntity() {
    return new TestEntity(null, this.username, this.something);
  }

}
