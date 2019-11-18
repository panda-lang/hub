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

package org.panda_lang.reposilite.error;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ErrorDtoTest {

    @Test
    void getCode() {
        ErrorDto errorDto = new ErrorDto(404, null);
        assertEquals(404, errorDto.getCode());
    }

    @Test
    void getMessage() {
        ErrorDto errorDto = new ErrorDto(-1, "error message");
        assertEquals("error message", errorDto.getMessage());
    }

}