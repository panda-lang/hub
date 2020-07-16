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

package org.panda_lang.hub.utils.converter;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Map;

public class ObjectToMapConverter implements Converter<Map<String, Object>, Object> {

  private final static ObjectMapper OBJECT_MAPPER = new ObjectMapper();

  @Override
  public Map<String, Object> convert(Object dto) {
    return OBJECT_MAPPER.convertValue(dto, new TypeReference<Map<String, Object>>() {});
  }

}
