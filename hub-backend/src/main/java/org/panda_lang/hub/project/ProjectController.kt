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
package org.panda_lang.hub.project

import io.swagger.annotations.ApiOperation
import org.bson.types.ObjectId
import org.panda_lang.hub.utils.entity.AbstractCrudController
import org.springframework.data.domain.PageRequest
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import kotlin.math.ceil

private const val PAGE_SIZE = 10

@ApiOperation("Operations pertaining to projects")
@RestController
@RequestMapping("/api/projects")
internal class ProjectController(
    service: ProjectService
) : AbstractCrudController<ProjectService, Project, ObjectId?, ProjectUpdateDto, ProjectUpdateDto>(service) {

    @ApiOperation("Always returns empty list")
    @GetMapping
    override fun readAll(): ResponseEntity<List<Project>> {
        return ResponseEntity.noContent().build()
    }

    @ApiOperation("Returns amount of projects")
    @GetMapping("/count")
    fun count(): ResponseEntity<Long> {
        return ResponseEntity.ok(service.count())
    }

    @ApiOperation("Returns amount of pages")
    @GetMapping("/page")
    fun pages(): ResponseEntity<Int> {
        return ResponseEntity.ok(ceil(service.count().toDouble() / PAGE_SIZE).toInt())
    }

    @ApiOperation("Returns page with up to $PAGE_SIZE projects")
    @GetMapping("/page/{number}")
    fun page(@PathVariable number: Int?): ResponseEntity<List<Project?>> {
        return ResponseEntity.ok(service
                .findAll(PageRequest.of(number!!, PAGE_SIZE))
                .content
        )
    }

    @ApiOperation("Returns all repositories that belongs to the requested user")
    @GetMapping("/user/{user}")
    fun userProjects(@PathVariable user: String?): ResponseEntity<List<Project?>?> {
        val projects = service.findAllByOwnerName(user) ?: emptyList()
        return ResponseEntity.ok(projects)
    }
}
