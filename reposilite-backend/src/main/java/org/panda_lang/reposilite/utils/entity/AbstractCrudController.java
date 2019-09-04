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

package org.panda_lang.reposilite.utils.entity;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.panda_lang.reposilite.utils.BeanUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

public abstract class AbstractCrudController<T extends IdentifiableEntity<ID>, ID, U extends AbstractDto<T>, C extends AbstractDto<T>> {

    @SuppressWarnings({ "ELValidationInJSP", "SpringElInspection" })
    private static final String SPEL_EXPRESSION = "(isAuthenticated() && principal.user.identifier.equals(#id)) || hasAuthority('ADMIN')";

    private final CrudOperationsService<T, ID> service;

    protected AbstractCrudController(CrudOperationsService<T, ID> service) {
        this.service = service;
    }

    @ApiOperation("Displays all entities")
    @GetMapping
    protected ResponseEntity<List<T>> readAll() {
        return ResponseEntity.ok(this.service.findAll());
    }


    @ApiOperation("Displays specified entity by it's identifier")
    @ApiResponses({
            @ApiResponse(code = 404, message = "Entity could not be found"),
            @ApiResponse(code = 200, message = "Entity found and displayed")
    })
    @GetMapping("/{id}")
    public ResponseEntity<T> read(@PathVariable @ApiParam("Entity identifier") ID id) {
        return this.service.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @ApiOperation("Creates entity")
    @ApiResponses({
            @ApiResponse(code = 409, message = "Entity already exists"),
            @ApiResponse(code = 400, message = "Validation error occurred"),
            @ApiResponse(code = 201, message = "Entity created")
    })
    @PostMapping
    protected ResponseEntity<?> create(
            @RequestBody @Valid @ApiParam("Entity data transfer object") C dto,
            BindingResult result
    ) {
        return this.createEntity(dto, result);
    }

    @ApiOperation("Updates entity")
    @ApiResponses({
            @ApiResponse(code = 201, message = "Entity created"),
            @ApiResponse(code = 400, message = "Validation error occurred"),
            @ApiResponse(code = 204, message = "Entity updated")
    })
    @PreAuthorize(SPEL_EXPRESSION)
    @PutMapping("/{id}")
    protected ResponseEntity<?> update(
            @RequestBody @Valid @ApiParam("Entity data transfer object") U dto,
            @PathVariable @ApiParam("Entity identifier") ID id,
            BindingResult result
    ) {
        Optional<T> entity = this.service.findById(id);

        if (!entity.isPresent()) {
            return this.createEntity(dto, result);
        }

        if (result.hasErrors()) {
            return ResponseEntity.badRequest().build();
        }

        BeanUtil.copyNonNullProperties(dto.toEntity(), entity.get());
        this.service.save(entity.get());
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @ApiOperation("Partial updates entity")
    @ApiResponses({
            @ApiResponse(code = 404, message = "Entity could not be found"),
            @ApiResponse(code = 204, message = "Entity updated")
    })
    @PreAuthorize(SPEL_EXPRESSION)
    @PatchMapping("/{id}")
    protected ResponseEntity<C> partialUpdate(
            @RequestBody @ApiParam("Entity data transfer object") U dto,
            @PathVariable @ApiParam("Entity identifier") ID id
    ) {
        Optional<T> optionalEntity = this.service.findById(id);

        if (!optionalEntity.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        BeanUtil.copyNonNullProperties(dto.toEntity(), optionalEntity.get());
        this.service.save(optionalEntity.get());
        return ResponseEntity.noContent().build();
    }

    @ApiOperation("Deletes entity")
    @ApiResponses({
            @ApiResponse(code = 404, message = "Entity could not be found"),
            @ApiResponse(code = 204, message = "Entity deleted")
    })
    @PreAuthorize(SPEL_EXPRESSION)
    @DeleteMapping("/{id}")
    protected ResponseEntity<T> remove(@PathVariable @ApiParam("Entity identifier") ID id) {
        if (!this.service.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        this.service.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    private <X extends AbstractDto<T>> ResponseEntity<?> createEntity(X dto, BindingResult result) {
        T entity = dto.toEntity();

        if (this.service.findByName(dto.getName()).isPresent()) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }

        if (result.hasErrors()) {
            return ResponseEntity.badRequest().build();
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(this.service.save(entity));
    }

}
