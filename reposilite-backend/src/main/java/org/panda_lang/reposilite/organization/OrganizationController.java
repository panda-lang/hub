package org.panda_lang.reposilite.organization;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.panda_lang.reposilite.user.AuthenticatedUser;
import org.panda_lang.reposilite.user.User;
import org.panda_lang.reposilite.utils.security.IsUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Optional;

@ApiOperation("Operations pertaining to organization")
@RestController
@RequestMapping("api/organization/")
public class OrganizationController {

    private final OrganizationService organizationService;

    @Autowired
    public OrganizationController(OrganizationService organizationService) {
        this.organizationService = organizationService;
    }

    @IsUser
    @ApiOperation(value = "Create an organization")
    @ApiResponses({
            @ApiResponse(code = 409, message = "Organization with that name already exists"),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 201, message = "Successfully created organization", response = Organization.class)
    })
    @PostMapping
    public ResponseEntity<Organization> createOrganization(@Valid OrganizationCreationForm form, BindingResult result, @AuthenticatedUser User owner) {
        Optional<Organization> organization = this.organizationService.findByName(form.getName());

        if (organization.isPresent()) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }

        if (result.hasErrors()) {
            return ResponseEntity.badRequest().build();
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(this.organizationService.saveByForm(form, owner));
    }
}
