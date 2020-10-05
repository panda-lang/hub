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
package org.panda_lang.hub.utils

import org.panda_lang.hub.utils.entity.JsonDto
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.ResultMatcher
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import kotlin.Throws

object AbstractDtoUtils {
    @Throws(Exception::class)
    fun perform(mockMvc: MockMvc?, uri: String?, dto: JsonDto, resultMatcher: ResultMatcher?) {
        mockMvc.perform(
            MockMvcRequestBuilders.post(uri)
                .content(dto.toJson().getBytes())
                .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(resultMatcher)
    }
}
