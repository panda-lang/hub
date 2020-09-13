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
package org.panda_lang.hub.error

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.web.servlet.error.ErrorAttributes
import org.springframework.boot.web.servlet.error.ErrorController
import org.springframework.context.MessageSource
import org.springframework.validation.FieldError
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.context.request.WebRequest
import java.util.*
import javax.servlet.http.HttpServletResponse

@RestController
internal class CustomErrorController(
        private val errorAttributes: ErrorAttributes,
        private val messageSource: MessageSource
) : ErrorController {

    companion object {
        private const val ERROR_PATH = "/error"
    }

    @RequestMapping(ERROR_PATH) // For all HTTP methods
    fun error(webRequest: WebRequest?, httpServletResponse: HttpServletResponse): ErrorDto {
        val errorAttributes = errorAttributes.getErrorAttributes(webRequest, false)

        if (httpServletResponse.status == 400 && errorAttributes["errors"] != null) {
            val errors = errorAttributes["errors"] as Collection<FieldError>?
            return ErrorDto(400, errors!!.stream()
                    .map { fieldError: FieldError? -> messageSource.getMessage(fieldError, Locale.getDefault()) }
                    .findFirst()
                    .get())
        }

        return ErrorDto(httpServletResponse.status, errorAttributes["error"].toString())
    }

    override fun getErrorPath(): String {
        return ERROR_PATH
    }

}