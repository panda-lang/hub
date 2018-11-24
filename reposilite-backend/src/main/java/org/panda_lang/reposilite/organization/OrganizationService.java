package org.panda_lang.reposilite.organization;

import java.util.Optional;

public interface OrganizationService {

    Optional<Organization> findByName(String name);

}
