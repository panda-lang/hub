package org.panda_lang.reposilite.organization;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
class OrganizationServiceImpl implements OrganizationService {

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
    public Optional<Organization> findById(ObjectId objectId) {
        return this.organizationRepository.findById(objectId);
    }

    @Override
    public List<Organization> findAll() {
        return this.organizationRepository.findAll();
    }

    @Override
    public <S extends Organization> S save(S entity) {
        return this.organizationRepository.save(entity);
    }

    @Override
    public void deleteById(ObjectId objectId) {
        this.organizationRepository.deleteById(objectId);
    }

    @Override
    public boolean existsById(ObjectId objectId) {
        return this.organizationRepository.existsById(objectId);
    }

}
