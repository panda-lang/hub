/*
 * Copyright (c) 2018-2019 Reposilite Team
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

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
