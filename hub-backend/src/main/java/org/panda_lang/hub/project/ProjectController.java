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

package org.panda_lang.hub.project;

import io.swagger.annotations.ApiOperation;
import org.bson.types.ObjectId;
import org.panda_lang.hub.utils.entity.AbstractCrudController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@ApiOperation("Operations pertaining to projects")
@RestController
@RequestMapping("/api/projects")
class ProjectController extends AbstractCrudController<ProjectService, Project, ObjectId, ProjectUpdateDto, ProjectUpdateDto> {

    private static final int PAGE_SIZE = 10;

    @Autowired
    protected ProjectController(ProjectService service) {
        super(service);
    }

    @ApiOperation("Always returns empty list")
    @GetMapping
    @Override
    protected ResponseEntity<List<Project>> readAll() {
        return ResponseEntity.noContent().build();
    }

    @ApiOperation("Returns amount of projects")
    @GetMapping("/count")
    protected ResponseEntity<Long> count() {
        return ResponseEntity.ok(super.getService().count());
    }

    @ApiOperation("Returns amount of pages")
    @GetMapping("/page")
    protected ResponseEntity<Integer> pages() {
        return ResponseEntity.ok((int) Math.ceil(super.getService().count() / (float) PAGE_SIZE));
    }

    @ApiOperation("Returns page with up to " + PAGE_SIZE + " projects")
    @GetMapping("/page/{number}")
    protected ResponseEntity<List<Project>> page(@PathVariable Integer number) {
        return ResponseEntity.ok(super.getService()
                .findAll(PageRequest.of(number, PAGE_SIZE))
                .getContent());
    }

    @ApiOperation("Returns all repositories that belongs to the requested user")
    @GetMapping("/user/{user}")
    protected ResponseEntity<List<Project>> userProjects(@PathVariable String user) {
        return ResponseEntity.ok(super.getService().findAllByOwnerName(user));
    }

}
