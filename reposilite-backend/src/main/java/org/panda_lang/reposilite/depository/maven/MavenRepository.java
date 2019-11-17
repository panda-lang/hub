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

package org.panda_lang.reposilite.depository.maven;

import org.panda_lang.reposilite.ReposiliteApplication;
import org.panda_lang.reposilite.depository.DepositoryEntity;
import org.panda_lang.reposilite.depository.DepositoryTree;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Repository
class MavenRepository {

    private final DepositoryFacade facade;
    private final File repositoriesRoot;
    private final Map<String, DepositoryTree<? extends Depository>> depositories;

    @Autowired
    public MavenRepository(DepositoryFacade facade, @Qualifier("repositoriesDirectory") File repositoriesRoot) {
        this.facade = facade;
        this.repositoriesRoot = new File(repositoriesRoot, "maven");
        this.depositories = new HashMap<>();
    }

    @EventListener
    public void seed(ContextRefreshedEvent event) {
        ReposiliteApplication.getLogger().info("Loading maven repositories from " + repositoriesRoot + "...");
        Collection<Depository> loadedDepositories = facade.loadDepositories(this.repositoriesRoot);

        for (Depository loadedDepository : loadedDepositories) {
            DepositoryTree<?> node = loadedDepository.getNode();
            //noinspection unchecked
            this.depositories.put(loadedDepository.getName(), (DepositoryTree<? extends Depository>) node);
        }

        if (depositories.isEmpty()) {
            ReposiliteApplication.getLogger().warn("Repositories not found!");
            return;
        }

        ReposiliteApplication.getLogger().info(depositories.size() + " maven repositories have been found");
    }

    public @Nullable DepositoryEntity findEntityByURLPath(String uri) {
        int index = uri.indexOf('/');
        Depository depository = findDepositoryByName(index == -1 ? uri : uri.substring(0, index));

        if (index == -1 || depository == null) {
            return depository;
        }

        Optional<DepositoryEntity> entity = depository.find(uri.substring(index + 1));

        if (!entity.isPresent()) {
            entity = depository.find(uri);
        }

        return entity.orElse(null);
    }

    private @Nullable DepositoryTree<? extends Depository> findDepositoryNodeByName(String name) {
        return this.depositories.get(name);
    }

    public @Nullable Depository findDepositoryByName(String name) {
        DepositoryTree<? extends Depository> node = findDepositoryNodeByName(name);

        if (node == null) {
            return null;
        }

        return node.getElement();
    }

    public Set<Depository> findAll() {
        return this.depositories.values().stream()
                .map(DepositoryTree::getElement)
                .collect(Collectors.toSet());
    }

}
