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

import org.panda_lang.reposilite.utils.AbstractDto;

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
