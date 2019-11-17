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

package org.panda_lang.reposilite.depository.panda;

import org.panda_lang.reposilite.ReposiliteApplication;
import org.panda_lang.reposilite.depository.DepositoryEntity;
import org.panda_lang.reposilite.depository.DepositoryUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;

@Repository
class PandaRepository {

    private final PackageFacade facade;
    private final File packagesRoot;
    private final Map<String, OwnerEntity> owners = new HashMap<>();

    @Autowired
    PandaRepository(PackageFacade facade, @Qualifier("repositoriesDirectory") File packagesRoot) {
        this.facade = facade;
        this.packagesRoot = new File(packagesRoot, "panda");
    }

    @EventListener
    public void seed(ContextRefreshedEvent event) {
        ReposiliteApplication.getLogger().info("Loading Panda packages from " + packagesRoot + "...");
        Map<String, DepositoryEntity> entities = facade.loadPackages(packagesRoot);

        for (Entry<String, DepositoryEntity> entity : entities.entrySet()) {
            owners.put(entity.getKey(), (OwnerEntity) entity.getValue());
            DepositoryUtils.print(entity.getValue());
        }

        if (owners.isEmpty()) {
            ReposiliteApplication.getLogger().warn("Repositories not found!");
            return;
        }

        long sum = owners.values().stream()
                .mapToLong(entity -> entity.getChildren().size())
                .sum();

        ReposiliteApplication.getLogger().info(sum + " panda packages have been found");
    }

    Optional<DepositoryEntity> findEntityByURLPath(String entityQualifier) {
        return Optional.empty();
    }

    Collection<? extends OwnerEntity> getOwners() {
        return owners.values();
    }

}
