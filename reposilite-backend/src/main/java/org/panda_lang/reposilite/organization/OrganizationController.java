package org.panda_lang.reposilite.organization;

import io.swagger.annotations.ApiOperation;
import org.bson.types.ObjectId;
import org.panda_lang.reposilite.utils.entity.AbstractCrudController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@ApiOperation("Operations pertaining to organization")
@RestController
@RequestMapping("/api/organizations")
public class OrganizationController extends AbstractCrudController<Organization, ObjectId, OrganizationUpdateDto, OrganizationUpdateDto> {

    // TODO Organization create DTO
    protected OrganizationController(@Autowired OrganizationService service) {
        super(service);
    }

}
