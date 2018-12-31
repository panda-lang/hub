package org.panda_lang.reposilite.utils;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.apache.commons.beanutils.BeanUtilsBean;
import org.bson.types.ObjectId;
import org.panda_lang.reposilite.utils.security.IsAdmin;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.lang.reflect.InvocationTargetException;
import java.util.Optional;

public abstract class AbstractCrudRestController<T extends IdentifiableEntity<ObjectId>> {

    private static final String NAME_PATH = "/by-name/";
    private static final String ID_PATH = "/by-id/";
    private static final BeanUtilsBean BEAN_UTILS_BEAN = new NullAwareBeanUtilsBean();

    private final NameableMongoRepository<T, ObjectId> repository;

    public AbstractCrudRestController(NameableMongoRepository<T, ObjectId> repository) {
        this.repository = repository;
    }

    @ApiOperation("Creates new entity")
    @ApiResponses({
            @ApiResponse(code = 409, message = "Entity already exists"),
            @ApiResponse(code = 201, message = "Successfully created entity")
    })
    @PostMapping
    public ResponseEntity<T> create(@RequestBody @Valid T entity, BindingResult result) {
        if (this.repository.findById(entity.getIdentifier()).isPresent()) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }

        if (result.hasErrors()) {
            return ResponseEntity.badRequest().build();
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(this.repository.save(entity));
    }

    @ApiOperation("Returns entity by name if present")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Successfully returned"),
            @ApiResponse(code = 404, message = "Name doesn't match to any entity")
    })
    @GetMapping(NAME_PATH + "{name}")
    public ResponseEntity<T> getByName(@PathVariable @ApiParam("Entity name") String name) {
        return this.repository.findByName(name)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @ApiOperation("Updates entity by name")
    @ApiResponses({
            @ApiResponse(code = 404, message = "Name doesn't match to any entity"),
            @ApiResponse(code = 204, message = "Successfully updated")
    })
    @IsAdmin
    @PutMapping(NAME_PATH + "{name}")
    public ResponseEntity<T> updateByName(@RequestBody T entity, @PathVariable @ApiParam("Entity name") String name, BindingResult result) {
        if (!this.repository.findByName(name).isPresent()) {
            return ResponseEntity.notFound().build();
        }

        if (result.hasErrors()) {
            return ResponseEntity.badRequest().build();
        }

        this.repository.save(entity);
        return ResponseEntity.noContent().build();
    }

    @ApiOperation("Partial updates entity by name")
    @ApiResponses({
            @ApiResponse(code = 404, message = "Name doesn't match to any entity"),
            @ApiResponse(code = 204, message = "Successfully updated")
    })
    @IsAdmin
    @PatchMapping(NAME_PATH + "{name}")
    public ResponseEntity<T> partialUpdateByName(@RequestBody T entity, @PathVariable @ApiParam("Entity name") String name) throws InvocationTargetException, IllegalAccessException {
        return this.partialUpdateEntity(entity, this.repository.findByName(name));
    }

    @ApiOperation("Deletes entity by name")
    @ApiResponses({
            @ApiResponse(code = 404, message = "Name doesn't match to any entity"),
            @ApiResponse(code = 204, message = "Successfully deleted")
    })
    @IsAdmin
    @DeleteMapping(NAME_PATH + "{name}")
    public ResponseEntity<T> removeByName(@PathVariable @ApiParam("Entity name") String name) {
        if (!this.repository.existsByName(name)) {
            return ResponseEntity.notFound().build();
        }

        this.repository.deleteByName(name);
        return ResponseEntity.noContent().build();
    }

    @ApiOperation("Returns entity by identifier if present")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Successfully returned"),
            @ApiResponse(code = 404, message = "Identifier doesn't match to any entity")
    })
    @GetMapping(ID_PATH + "{identifier}")
    public ResponseEntity<T> getByIdentifier(@PathVariable @ApiParam("Entity identifier") String identifier) {
        return this.repository.findById(new ObjectId(identifier))
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @ApiOperation("Updates entity by identifier")
    @ApiResponses({
            @ApiResponse(code = 404, message = "Identifier doesn't match to any entity"),
            @ApiResponse(code = 204, message = "Successfully updated")
    })
    @IsAdmin
    @PutMapping(ID_PATH + "{identifier}")
    public ResponseEntity<T> updateByIdentifier(@RequestBody T entity, @PathVariable @ApiParam("Entity identifier") String identifier, BindingResult result) {
        if (!this.repository.findById(new ObjectId(identifier)).isPresent()) {
            return ResponseEntity.notFound().build();
        }

        if (result.hasErrors()) {
            return ResponseEntity.badRequest().build();
        }

        this.repository.save(entity);
        return ResponseEntity.noContent().build();
    }

    @ApiOperation("Partial updates entity by identifier")
    @ApiResponses({
            @ApiResponse(code = 404, message = "Identifier doesn't match to any entity"),
            @ApiResponse(code = 204, message = "Successfully updated")
    })
    @IsAdmin
    @PatchMapping(ID_PATH + "{identifier}")
    public ResponseEntity<T> partialUpdateByIdentifier(@RequestBody T entity, @PathVariable @ApiParam("Entity identifier") String identifier) throws InvocationTargetException, IllegalAccessException {
        return this.partialUpdateEntity(entity, this.repository.findById(new ObjectId(identifier)));
    }

    @ApiOperation("Deletes entity by identifier")
    @ApiResponses({
            @ApiResponse(code = 404, message = "Identifier doesn't match to any entity"),
            @ApiResponse(code = 204, message = "Successfully deleted")
    })
    @IsAdmin
    @DeleteMapping(ID_PATH + "{identifier}")
    public ResponseEntity<T> removeByIdentifier(@PathVariable @ApiParam("Entity identifier") String identifier) {
        ObjectId id = new ObjectId(identifier);
        if (!this.repository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        this.repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    private ResponseEntity<T> partialUpdateEntity(@RequestBody T entity, Optional<T> optionalEntity) throws IllegalAccessException, InvocationTargetException {
        if (!optionalEntity.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        BEAN_UTILS_BEAN.copyProperties(optionalEntity.get(), entity);
        this.repository.save(optionalEntity.get());
        return ResponseEntity.noContent().build();
    }

}
