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

package org.panda_lang.reposilite.resource_fs;

import org.panda_lang.reposilite.ReposiliteApplication;
import org.panda_lang.reposilite.resource_fs.utils.ResourcesPathMapper;
import org.panda_lang.utilities.commons.StringUtils;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;

import java.io.File;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

public abstract class AbstractResourcesRepository<T extends Resource> implements ResourcesRepository<T> {

    private final File repositoryRoot;
    private final Map<String, T> entities = new HashMap<>();

    protected AbstractResourcesRepository(File repositoryRoot) {
        this.repositoryRoot = repositoryRoot;
    }

    /**
     * Called to fetch path mapper related to the repository implementation
     *
     * @return the resources path mapper
     */
    public abstract ResourcesPathMapper initializeMapper();

    /**
     * Called after seeding process
     */
    public abstract void onLoad();

    @EventListener
    @SuppressWarnings("unchecked")
    public void seed(ContextRefreshedEvent event) {
        ResourcesPathMapper mapper = initializeMapper();

        for (Resource loadedEntity : mapper.map(repositoryRoot).values()) {
            getEntities().put(loadedEntity.getName(), (T) loadedEntity);
            print(loadedEntity);
        }

        if (getEntities().isEmpty()) {
            ReposiliteApplication.getLogger().warn("Repositories not found!");
        }

        onLoad();
    }

    private void print(Resource entity) {
        ReposiliteApplication.getLogger().info("└── " + entity.getName());

        for (Resource child : entity.getChildren()) {
            printEntity(1, child);
        }
    }

    private void printEntity(int level, Resource entity) {
        if (entity instanceof ProjectResource) {
            ReposiliteApplication.getLogger().info(StringUtils.buildSpace((level - 1) * 3) + "│  ├── " + entity);
            return;
        }

        ReposiliteApplication.getLogger().info(StringUtils.buildSpace(level * 3) + "├── " + entity.getName());

        for (Resource child : entity.getChildren()) {
            printEntity(level + 1, child);
        }
    }

    @Override
    public Optional<? extends Resource> findEntityByURLPath(String path) {
        int index = path.indexOf('/');
        Optional<T> entityValue = findEntityByName(index == -1 ? path : path.substring(0, index));

        if (index == -1 || !entityValue.isPresent()) {
            return entityValue;
        }

        return entityValue.get()
                .find(path.substring(index + 1))
                .map(Optional::of)
                .orElseGet(() -> entityValue.get().find(path));
    }

    @Override
    public Optional<T> findEntityByName(String name) {
        return Optional.ofNullable(entities.get(name));
    }

    @Override
    public Set<T> findAll() {
        return new HashSet<>(entities.values());
    }

    protected Map<String, T> getEntities() {
        return entities;
    }

    protected File getRepositoryRoot() {
        return repositoryRoot;
    }

}
