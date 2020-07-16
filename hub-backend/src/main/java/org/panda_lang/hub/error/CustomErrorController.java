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

package org.panda_lang.hub.error;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.context.MessageSource;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import javax.servlet.http.HttpServletResponse;
import java.util.Collection;
import java.util.Locale;
import java.util.Map;

@RestController
class CustomErrorController implements ErrorController {

    private static final String ERROR_PATH = "/error";

    private final ErrorAttributes errorAttributes;
    private final MessageSource messageSource;

    @Autowired
    public CustomErrorController(ErrorAttributes errorAttributes, MessageSource messageSource) {
        this.errorAttributes = errorAttributes;
        this.messageSource = messageSource;
    }

    @RequestMapping(ERROR_PATH) // For all HTTP methods
    public ErrorDto error(WebRequest webRequest, HttpServletResponse httpServletResponse) {
        Map<String, Object> errorAttributes = this.errorAttributes.getErrorAttributes(webRequest, false);

        if (httpServletResponse.getStatus() == 400 && errorAttributes.get("errors") != null) {
            //noinspection unchecked
            Collection<FieldError> errors = (Collection<FieldError>) errorAttributes.get("errors");

            return new ErrorDto(400, errors.stream()
                    .map(fieldError -> this.messageSource.getMessage(fieldError, Locale.getDefault()))
                    .findFirst()
                    .get());
        }

        return new ErrorDto(httpServletResponse.getStatus(), errorAttributes.get("error").toString());
    }

    @Override
    public String getErrorPath() {
        return ERROR_PATH;
    }

}
