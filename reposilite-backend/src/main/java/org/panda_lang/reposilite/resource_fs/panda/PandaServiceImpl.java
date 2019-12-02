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

package org.panda_lang.reposilite.resource_fs.panda;

import org.panda_lang.reposilite.resource_fs.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
class PandaServiceImpl implements PandaService {

    private final PandaRepository repository;

    @Autowired
    PandaServiceImpl(PandaRepository repository) {
        this.repository = repository;
    }

    @Override
    public Optional<? extends Resource> findEntityByQualifier(String entityQualifier) {
        return this.repository.findEntityByURLPath(entityQualifier);
    }

    @Override
    public Collection<? extends Resource> getEntities() {
        return repository.findAll();
    }

}