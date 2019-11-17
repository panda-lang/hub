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

package org.panda_lang.reposilite.depository.utils;

import org.apache.commons.io.FilenameUtils;
import org.panda_lang.reposilite.ReposiliteApplication;
import org.panda_lang.reposilite.depository.DepositoryEntity;
import org.panda_lang.utilities.commons.FileUtils;
import org.panda_lang.utilities.commons.StringUtils;
import org.panda_lang.utilities.commons.collection.map.TreeNode;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

public final class DepositoryPathMapper {

    private final DepositoryPath path;
    private final Collection<String> extensions = new ArrayList<>();
    private final Map<String, PathMapper> mappers = new HashMap<>();

    public DepositoryPathMapper(String pattern) {
        this.path = DepositoryPath.parse(pattern);
    }

    public DepositoryPathMapper registerExtensions(String... extension) {
        extensions.addAll(Arrays.asList(extension));
        return this;
    }

    public DepositoryPathMapper registerMapper(String placeholder, PathMapper pathMapper) {
        mappers.put(placeholder, pathMapper);
        return this;
    }

    public Map<String, DepositoryEntity> map(File rootDirectory) {
        Map<String, DepositoryEntity> entities = new HashMap<>();

        TreeNode<File> directories = FileUtils.collectFiles(rootDirectory);
        Set<File> files = directories.collectLeafs(file -> extensions.contains(FilenameUtils.getExtension(file.getName())));

        for (File file : files) {
            mapFile(entities, rootDirectory, file).ifPresent(entity -> entities.put(entity.getName(), entity));
        }

        return entities;
    }

    private Optional<DepositoryEntity> mapFile(Map<String, DepositoryEntity> entities, File rootDirectory, File file) {
        String qualifier = file.toString().replace(rootDirectory.toString(), "");

        // remove first file separator if exists
        if (qualifier.startsWith(File.separator)) {
            qualifier = qualifier.substring(1);
        }

        String[] elements = StringUtils.split(qualifier, File.separator);

        // skip paths with invalid amount of elements
        if (elements.length < path.getElements().size()) {
            ReposiliteApplication.getLogger().info("Skipping " + file);
            return Optional.empty();
        }

        DepositoryEntity parent = null;
        DepositoryEntity previous = null;

        for (int index = 0; index < elements.length; index++) {
            DepositoryUnit unit = path.forElement(elements.length, index);
            String value = elements[index];

            // skip static elements of path
            if (unit.isStatic()) {
                if (unit.getName().equals(value)) {
                    continue;
                }

                ReposiliteApplication.getLogger().warn("Unknown element: " + file);
                break;
            }

            PathMapper mapper = mappers.get(unit.getName());
            DepositoryEntity entity;

            // get parent entity or create a new one
            if (previous == null) {
                entity = entities.get(value);

                if (entity == null) {
                    entity = mapper.apply(null, value);
                }

                parent = entity;
            }
            // get or create child entity
            else {
                entity = mapPrevious(previous, value, mapper);
            }

            previous = entity;
        }

        return Optional.ofNullable(parent);
    }

    private DepositoryEntity mapPrevious(DepositoryEntity previous, String value, PathMapper mapper) {
        return previous.getChild(value).orElseGet(() -> {
            DepositoryEntity entity = mapper.apply(previous, value);
            previous.addEntity(entity);
            return entity;
        });
    }

}
