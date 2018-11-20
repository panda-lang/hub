package org.panda_lang.reposilite.organization;

import org.panda_lang.reposilite.user.User;

import java.util.Optional;

public interface OrganizationService {

    Optional<Organization> findByName(String name);

    Optional<Organization> findByOwner(User owner);

    Organization saveByForm(OrganizationCreationForm form, User owner);

}
