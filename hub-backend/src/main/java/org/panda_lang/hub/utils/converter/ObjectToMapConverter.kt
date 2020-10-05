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
package org.panda_lang.hub.utils.converter

import com.fasterxml.jackson.core.type.TypeReference
import com.fasterxml.jackson.databind.ObjectMapper

class ObjectToMapConverter : Converter<Map<String, Any>, Any?> {

    companion object {
        private val OBJECT_MAPPER = ObjectMapper()
    }

    override fun convert(dto: Any?): Map<String, Any> {
        return OBJECT_MAPPER.convertValue<Map<String, Any>>(dto!!, object : TypeReference<Map<String, Any>>() {})
    }
}
