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

import org.panda_lang.reposilite.ReposiliteApplication;
import org.panda_lang.reposilite.resource.Resource;
import org.panda_lang.reposilite.resource.ResourcesSubService;
import org.panda_lang.utilities.commons.StringUtils;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public final class ResourcesPathMapper<R extends Resource<R>> {

    private final ResourcesSubService<R> service;
    private final ResourcePath path;
    private final Map<String, PathMapper<R>> mappers = new HashMap<>();

    public ResourcesPathMapper(ResourcesSubService<R> service, String pattern) {
        this.service = service;
        this.path = ResourcePath.parse(pattern);
    }

    public ResourcesPathMapper<R> registerMapper(String placeholder, PathMapper<R> pathMapper) {
        mappers.put(placeholder, pathMapper);
        return this;
    }

    public Optional<R> map(String qualifier) {
        // remove first file separator if exists
        if (qualifier.startsWith(File.separator)) {
            qualifier = qualifier.substring(1);
        }

        String[] elements = StringUtils.split(qualifier, "/");

        // skip paths with invalid amount of elements
        if (elements.length < path.getElements().size()) {
            ReposiliteApplication.getLogger().warn("Skipping " + qualifier);
            return Optional.empty();
        }

        R previous = null;

        for (int index = 0; index < elements.length; index++) {
            ResourceUnit unit = path.forElement(elements.length, index);
            String value = elements[index];

            // skip static elements of path
            if (unit.isStatic()) {
                if (unit.getName().equals(value)) {
                    continue;
                }

                ReposiliteApplication.getLogger().warn("Unknown element: " + qualifier + " (" + value + ")");
                return Optional.empty();
            }

            PathMapper<R> mapper = mappers.get(unit.getName());

            if (mapper == null) {
                throw new UnsupportedOperationException("Unknown unit " + unit.getName());
            }

            R entity;

            // get parent entity or create a new one
            if (previous == null) {
                entity = service.findByName(value).orElse(null);

                if (entity == null) {
                    entity = mapper.apply(service.getServiceDirectory(), null, value);
                }
            }
            // get or create child entity
            else {
                entity = mapPrevious(service.getServiceDirectory(), previous, value, mapper);
            }

            previous = entity;
        }

        return Optional.ofNullable(previous);
    }

    private R mapPrevious(File file, R previous, String value, PathMapper<R> mapper) {
        return previous.getResource(value).orElseGet(() -> {
            R resource = service.save(mapper.apply(file, previous, value));
            previous.addResource(resource);
            service.save(previous);
            return resource;
        });
    }

}
