package org.panda_lang.reposilite.organization;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.panda_lang.reposilite.utils.rest.AbstractCrudRestController;
import org.panda_lang.reposilite.utils.security.IsUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@ApiOperation("Operations pertaining to organization")
@RestController
@RequestMapping("api/organization/")
public class OrganizationController extends AbstractCrudRestController<Organization> {

    @Autowired
    public OrganizationController(OrganizationRepository organizationRepository) {
        super(organizationRepository);
    }

    @IsUser
    @ApiOperation(value = "Create an organization")
    @ApiResponses({
            @ApiResponse(code = 409, message = "Organization with that name already exists"),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 201, message = "Successfully created organization", response = Organization.class)
    })
    @Override
    public ResponseEntity<Organization> create(Organization entity, BindingResult result) {
        return super.create(entity, result);
    }

}
