package org.panda_lang.reposilite.organization;

import org.panda_lang.reposilite.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrganizationServiceImpl implements OrganizationService {

    private final OrganizationRepository organizationRepository;

    @Autowired
    public OrganizationServiceImpl(OrganizationRepository organizationRepository) {
        this.organizationRepository = organizationRepository;
    }

    @Override
    public Optional<Organization> findByName(String name) {
        return this.organizationRepository.findByName(name);
    }

    @Override
    public Optional<Organization> findByOwner(User owner) {
        return this.organizationRepository.findByOwner(owner);
    }

    @Override
    public Organization saveByForm(OrganizationCreationForm form, User owner) {
        Organization organization = new OrganizationBuilder()
                .withName(form.getName())
                .withDescription(form.getDescription())
                .withDisplayName(form.getDisplayName())
                .withEmail(form.getEmail())
                .withSite(form.getSite())
                .withOwner(owner)
                .build();

        return this.organizationRepository.save(organization);
    }

}
