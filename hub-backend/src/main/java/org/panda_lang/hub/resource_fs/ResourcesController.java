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

package org.panda_lang.hub.resource_fs;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@ApiOperation("Operations on repositories")
@RestController("/api/resources_fs")
class ResourcesController {

    private final FSResourcesService resourcesService;

    @Autowired
    ResourcesController(FSResourcesService resourcesService) {
        this.resourcesService = resourcesService;
    }

    @GetMapping
    ResponseEntity<Set<String>> list() {
        return ResponseEntity.ok(resourcesService.getSubServicesNames());
    }

}
