package org.panda_lang.reposilite.organization;

import io.swagger.annotations.ApiOperation;
import org.panda_lang.reposilite.utils.AbstractCrudRestController;
import org.springframework.beans.factory.annotation.Autowired;
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

}
