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

package org.panda_lang.reposilite.utils;

import org.apache.commons.io.IOUtils;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.ResponseEntity;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;

public final class ResponseUtils {

    private ResponseUtils() { }

    public static ResponseEntity<Object> sendFile(HttpServletResponse response, String contentType, File file) throws IOException {
        response.addHeader("Content-Disposition", "attachment; filename=\"" + file.getName() + "\"");
        response.addHeader("Content-Type", contentType);
        response.addHeader("Content-Length", Long.toString(file.length()));

        IOUtils.copy(new FileSystemResource(file).getInputStream(), response.getOutputStream());
        response.flushBuffer();

        return ResponseEntity.accepted().build();
    }

}
