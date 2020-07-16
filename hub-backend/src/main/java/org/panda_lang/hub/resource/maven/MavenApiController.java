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

package org.panda_lang.hub.resource.maven;

import io.swagger.annotations.ApiOperation;
import org.panda_lang.hub.resource.Resource;
import org.panda_lang.hub.resource.utils.ResourcesPathMapper;
import org.panda_lang.hub.user.role.IsAdmin;
import org.panda_lang.hub.utils.FilesUtils;
import org.panda_lang.hub.utils.RequestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.Optional;

@ApiOperation("Operations pertaining to the Maven repositories")
@RequestMapping("/api/resources/maven")
@RestController
class MavenApiController {

    private final MavenService mavenService;
    private final ResourcesPathMapper<MavenResource> mapper;

    @Autowired
    public MavenApiController(MavenService mavenService) {
        this.mavenService = mavenService;

        this.mapper = new ResourcesPathMapper<>(mavenService, "{repository}/{*group}/{artifact}/{version}/{build}")
                .registerMapper("{repository}", (root, parent, name) -> new MavenResource(name, new File(root, name), MavenResourceType.REPOSITORY, null))
                .registerMapper("{group}", (file, parent, name) -> new MavenResource(name, new File(parent.getFile(), name), MavenResourceType.GROUP, parent))
                .registerMapper("{artifact}", (file, parent, name) -> new MavenResource(name, new File(parent.getFile(), name), MavenResourceType.ARTIFACT, parent))
                .registerMapper("{version}", (file, parent, name) -> new MavenResource(name, new File(parent.getFile(), name), MavenResourceType.VERSION, parent))
                .registerMapper("{build}", (file, parent, name) -> new MavenResource(name, new File(parent.getFile(), name), MavenResourceType.BUILD, parent));
    }

    @GetMapping("/**")
    ResponseEntity<MavenResource> list(HttpServletRequest request) {
        return ResponseEntity.ok(mavenService.findByQulifier(RequestUtils.extractWildcard(request)).get());
    }

    @IsAdmin
    @PutMapping("/**")
    ResponseEntity<?> upload(@RequestParam(value = "data") MultipartFile requestFile, HttpServletRequest request) {
        return Optional.ofNullable(requestFile)
                .flatMap(file -> mapper.map(RequestUtils.extractWildcard(request)))
                .filter(Resource::isLoadable)
                .map(resource -> {
                    FilesUtils.storeFile(resource.getFile().getParentFile().toPath(), requestFile, false);
                    FilesUtils.writeFileChecksums(resource.getFile().toPath().toAbsolutePath());
                    return ResponseEntity.accepted().build();
                })
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }

}
