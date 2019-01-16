package org.panda_lang.reposilite.organization;

import io.swagger.annotations.ApiOperation;
import org.bson.types.ObjectId;
import org.panda_lang.reposilite.utils.AbstractCrudController;
import org.panda_lang.reposilite.utils.CrudOperationsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@ApiOperation("Operations pertaining to organization")
@RestController
@RequestMapping("api/organization/")
public class OrganizationController extends AbstractCrudController<Organization, ObjectId, OrganizationUpdateDto, OrganizationUpdateDto> {

    // TODO Organization update and create DTOs
    protected OrganizationController(@Autowired OrganizationService service) {
        super(service);
    }

}
