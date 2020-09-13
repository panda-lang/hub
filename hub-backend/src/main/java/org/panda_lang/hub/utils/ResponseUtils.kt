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

import org.apache.commons.io.IOUtils
import org.springframework.core.io.FileSystemResource
import org.springframework.http.ResponseEntity
import java.io.File
import java.io.IOException
import javax.servlet.http.HttpServletResponse

object ResponseUtils {

    @Throws(IOException::class)
    fun sendFile(response: HttpServletResponse, contentType: String?, file: File): ResponseEntity<Any> {
        response.addHeader("Content-Disposition", "attachment; filename=\"" + file.name + "\"")
        response.addHeader("Content-Type", contentType)
        response.addHeader("Content-Length", java.lang.Long.toString(file.length()))
        IOUtils.copy(FileSystemResource(file).inputStream, response.outputStream)
        response.flushBuffer()
        return ResponseEntity.accepted().build()
    }

}