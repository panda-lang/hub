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

package org.panda_lang.reposilite.resource.utils;

import org.apache.commons.io.FilenameUtils;
import org.panda_lang.reposilite.ReposiliteApplication;
import org.panda_lang.reposilite.resource.Resource;
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

public final class ResourcesPathMapper {

    private final ResourcePath path;
    private final Collection<String> extensions = new ArrayList<>();
    private final Map<String, PathMapper> mappers = new HashMap<>();

    public ResourcesPathMapper(String pattern) {
        this.path = ResourcePath.parse(pattern);
    }

    public ResourcesPathMapper registerExtensions(String... extension) {
        extensions.addAll(Arrays.asList(extension));
        return this;
    }

    public ResourcesPathMapper registerMapper(String placeholder, PathMapper pathMapper) {
        mappers.put(placeholder, pathMapper);
        return this;
    }

    public Map<String, Resource> map(File rootDirectory) {
        Map<String, Resource> entities = new HashMap<>();

        TreeNode<File> directories = FileUtils.collectFiles(rootDirectory);
        Set<File> files = directories.collectLeafs(file -> extensions.contains(FilenameUtils.getExtension(file.getName())));

        for (File file : files) {
            mapFile(entities, rootDirectory, file).ifPresent(entity -> entities.put(entity.getName(), entity));
        }

        return entities;
    }

    private Optional<Resource> mapFile(Map<String, Resource> entities, File rootDirectory, File file) {
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

        Resource parent = null;
        Resource previous = null;

        for (int index = 0; index < elements.length; index++) {
            ResourceUnit unit = path.forElement(elements.length, index);
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

            if (mapper == null) {
                throw new UnsupportedOperationException("Unknown unit " + unit.getName());
            }

            Resource entity;

            // get parent entity or create a new one
            if (previous == null) {
                entity = entities.get(value);

                if (entity == null) {
                    entity = mapper.apply(file, null, value);
                }

                parent = entity;
            }
            // get or create child entity
            else {
                entity = mapPrevious(file, previous, value, mapper);
            }

            previous = entity;
        }

        return Optional.ofNullable(parent);
    }

    private Resource mapPrevious(File file, Resource previous, String value, PathMapper mapper) {
        return previous.getChild(value).orElseGet(() -> {
            Resource entity = mapper.apply(file, previous, value);
            previous.addEntity(entity);
            return entity;
        });
    }

}
