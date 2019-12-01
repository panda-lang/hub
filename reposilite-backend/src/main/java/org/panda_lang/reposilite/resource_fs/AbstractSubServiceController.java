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

package org.panda_lang.reposilite.resource_fs;

import org.apache.commons.io.FilenameUtils;
import org.panda_lang.reposilite.utils.RequestUtils;
import org.panda_lang.reposilite.utils.ResponseUtils;
import org.panda_lang.utilities.commons.collection.Maps;
import org.springframework.http.ResponseEntity;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.Optional;

public abstract class AbstractSubServiceController<T extends ResourcesSubService> {

    protected static final Map<String, String> SUPPORTED_EXTENSIONS = Maps.of(
            "jar", "application/java",
            "xml", "text/xml",
            "zip", "application/zip"
    );

    protected final T service;

    protected AbstractSubServiceController(T service) {
        this.service = service;
    }

    protected ResponseEntity<Object> getEntity(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String entityQualifier = RequestUtils.extractWildcard(request);
        Optional<? extends Resource> entityValue = service.findEntityByQualifier(entityQualifier);

        if (!entityValue.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        Resource entity = entityValue.get();

        if (entity instanceof ResultResource) {
            File file = entity.getFile();
            return ResponseUtils.sendFile(response, SUPPORTED_EXTENSIONS.get(FilenameUtils.getExtension(file.getName())), file);
        }

        return ResponseEntity.ok(entity.getChildrenNames());
    }

    protected T getService() {
        return service;
    }

}
