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

package org.panda_lang.hub.resource_fs.panda;

import io.swagger.annotations.ApiOperation;
import org.apache.commons.io.FilenameUtils;
import org.panda_lang.hub.resource_fs.AbstractSubServiceController;
import org.panda_lang.hub.resource_fs.Resource;
import org.panda_lang.hub.resource_fs.ProjectResource;
import org.panda_lang.hub.user.role.IsAdmin;
import org.panda_lang.hub.utils.FilesUtils;
import org.panda_lang.hub.utils.RequestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.Objects;
import java.util.Optional;

@ApiOperation("Operations pertaining to the Panda packages")
@RequestMapping("/api/repository/panda")
@RestController
class PandaController extends AbstractSubServiceController<PandaService> {

    @Autowired
    PandaController(PandaService pandaService) {
        super(pandaService);
    }

    @IsAdmin
    @PutMapping("/**")
    public ResponseEntity<Object> put(@RequestBody MultipartFile file, HttpServletRequest request) {
        if (!Objects.equals(FilenameUtils.getExtension(file.getOriginalFilename()), "zip")) {
            return ResponseEntity.badRequest().build();
        }

        Optional<? extends Resource> entityValue = super.getService().findEntityByQualifier(RequestUtils.extractWildcard(request));

        if (!entityValue.isPresent() || !(entityValue.get() instanceof ProjectResource)) {
            return ResponseEntity.notFound().build();
        }

        ProjectResource entity = (ProjectResource) entityValue.get();
        FilesUtils.storeFile(new File(entity.getFile(), "builds").toPath(), file, false);

        return ResponseEntity.noContent().build();
    }

    @GetMapping("/**")
    public ResponseEntity<Object> get(HttpServletRequest request, HttpServletResponse response) throws IOException {
        return super.getEntity(request, response);
    }

}
