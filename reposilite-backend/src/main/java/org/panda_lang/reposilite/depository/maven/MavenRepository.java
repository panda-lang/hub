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

import org.panda_lang.panda.utilities.commons.collection.map.TreemapNode;
import org.panda_lang.reposilite.ReposiliteApplication;
import org.panda_lang.reposilite.depository.DepositoryEntity;
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

    private final File repositoriesRoot;
    private final Map<String, TreemapNode<? extends Depository>> depositories;

    @Autowired
    public MavenRepository(@Qualifier("mavenRepositoryDirectory") File repositoriesRoot) {
        this.repositoriesRoot = repositoriesRoot;
        this.depositories = new HashMap<>();
    }

    @EventListener
    public void seed(ContextRefreshedEvent event) {
        ReposiliteApplication.getLogger().info("Loading maven repositories from " + repositoriesRoot + "...");

        DepositoryFactory factory = new DepositoryFactory();
        Collection<Depository> loadedDepositories = factory.loadDepositories(this.repositoriesRoot);

        for (Depository loadedDepository : loadedDepositories) {
            TreemapNode node = loadedDepository.getNode();
            //noinspection unchecked
            this.depositories.put(loadedDepository.getName(), (TreemapNode<? extends Depository>) node);
        }

        if (this.depositories.isEmpty()) {
            ReposiliteApplication.getLogger().warn("Repositories not found!");
            return;
        }

        ReposiliteApplication.getLogger().info("Result: " + this.depositories.size() + " repositories have been found");
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

    private @Nullable TreemapNode<? extends DepositoryEntity> findDepositoryNodeByName(String name) {
        return this.depositories.get(name);
    }

    public @Nullable Depository findDepositoryByName(String name) {
        TreemapNode<? extends Depository> node = depositories.get(name);

        if (node == null) {
            return null;
        }

        return node.getElement();
    }

    public Set<Depository> findAll() {
        return this.depositories.values().stream()
                .map(TreemapNode::getElement)
                .collect(Collectors.toSet());
    }

}
