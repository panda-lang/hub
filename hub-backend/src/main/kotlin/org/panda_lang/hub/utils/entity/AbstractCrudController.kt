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
package org.panda_lang.hub.utils.entity

import io.swagger.annotations.ApiOperation
import io.swagger.annotations.ApiParam
import io.swagger.annotations.ApiResponse
import io.swagger.annotations.ApiResponses
import org.panda_lang.hub.utils.BeanUtil
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.validation.BindingResult
import org.springframework.web.bind.annotation.*
import java.util.*
import javax.validation.Valid

/**
 * Default implementation of crud controller
 *
 * @param <T> type of entity
 * @param <ID> type of id
 * @param <U> type of update dto
 * @param <C> type of create dto
 */
abstract class AbstractCrudController<S : CrudOperationsService<T, ID>, T : IdentifiableEntity<ID>, ID, U : AbstractDto<T>, C : AbstractDto<T>>(
        protected open val service: S
) {

    companion object {
        private const val SPEL_EXPRESSION = "(isAuthenticated() && principal.user.identifier.equals(#id)) || hasAuthority('ADMIN')"
    }

    @ApiOperation("Displays all entities")
    @GetMapping
    protected open fun readAll(): ResponseEntity<List<T>> {
        return ResponseEntity.ok(service.findAll())
    }

    @ApiOperation("Displays specified entity by it's identifier")
    @ApiResponses(
            ApiResponse(code = 404, message = "Entity could not be found"),
            ApiResponse(code = 200, message = "Entity found and displayed")
    )
    @GetMapping("/{id}")
    fun read(@PathVariable @ApiParam("Entity identifier") id: ID): ResponseEntity<T> {
        return Optional.ofNullable(service.findById(id))
                .map { body: T -> ResponseEntity.ok(body) }
                .orElseGet { ResponseEntity.notFound().build() }
    }

    @ApiOperation("Creates entity")
    @ApiResponses(
            ApiResponse(code = 409, message = "Entity already exists"),
            ApiResponse(code = 400, message = "Validation error occurred"),
            ApiResponse(code = 201, message = "Entity created")
    )
    @PostMapping
    protected fun create(@RequestBody @ApiParam("Entity data transfer object") dto: @Valid C, result: BindingResult): ResponseEntity<*> {
        return createEntity(dto, result)
    }

    @ApiOperation("Updates entity")
    @ApiResponses(
            ApiResponse(code = 201, message = "Entity created"),
            ApiResponse(code = 400, message = "Validation error occurred"),
            ApiResponse(code = 204, message = "Entity updated")
    )
    @PreAuthorize(SPEL_EXPRESSION)
    @PutMapping("/{id}")
    protected fun update(@RequestBody @ApiParam("Entity data transfer object") dto: @Valid U, @PathVariable @ApiParam("Entity identifier") id: ID, result: BindingResult ): ResponseEntity<*> {
        val entity: T = service.findById(id) ?: return createEntity(dto, result)

        if (result.hasErrors()) {
            return ResponseEntity.badRequest().build<Any>()
        }

        BeanUtil.copyNonNullProperties(dto.toEntity(), entity)
        service.save(entity)

        return ResponseEntity
                .status(HttpStatus.NO_CONTENT)
                .build<Any>()
    }

    @ApiOperation("Partial updates entity")
    @ApiResponses(
            ApiResponse(code = 404, message = "Entity could not be found"),
            ApiResponse(code = 204, message = "Entity updated")
    )
    @PreAuthorize(SPEL_EXPRESSION)
    @PatchMapping("/{id}")
    protected fun partialUpdate(@RequestBody @ApiParam("Entity data transfer object") dto: U, @PathVariable @ApiParam("Entity identifier") id: ID): ResponseEntity<C> {
        val optionalEntity: T = service.findById(id) ?: return ResponseEntity.notFound().build()

        BeanUtil.copyNonNullProperties(dto.toEntity(), optionalEntity)
        service.save(optionalEntity)

        return ResponseEntity.noContent().build()
    }

    @ApiOperation("Deletes entity")
    @ApiResponses(
            ApiResponse(code = 404, message = "Entity could not be found"),
            ApiResponse(code = 204, message = "Entity deleted")
    )
    @PreAuthorize(SPEL_EXPRESSION)
    @DeleteMapping("/{id}")
    protected fun remove(@PathVariable @ApiParam("Entity identifier") id: ID): ResponseEntity<T> {
        if (!service.existsById(id)) {
            return ResponseEntity.notFound().build()
        }

        service.deleteById(id)
        return ResponseEntity.noContent().build()
    }

    private fun <X : AbstractDto<T>> createEntity(dto: X, result: BindingResult): ResponseEntity<*> {
        val entity: T = dto.toEntity()

        service.findByName(dto.name) ?: run {
            return ResponseEntity
                    .status(HttpStatus.CONFLICT)
                    .build<Any>()
        }

        if (result.hasErrors()) {
            return ResponseEntity
                    .badRequest()
                    .build<Any>()
        }

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(service.save(entity))
    }

}