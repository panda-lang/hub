/*
 * Copyright (c) 2018-2019 Hub Team
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

package org.panda_lang.hub.resource_fs.utils;

import org.panda_lang.utilities.commons.StringUtils;

final class ResourceUnit {

    private final String name;
    private final int required;
    private final boolean wildcard;
    private final boolean multipart;

    ResourceUnit(String name, int required, boolean wildcard, boolean multipart) {
        if (!wildcard && multipart) {
            throw new IllegalArgumentException("Cannot use multipart modifier without wildcard modifier");
        }

        this.name = name;
        this.required = required;
        this.wildcard = wildcard;
        this.multipart = multipart;
    }

    protected boolean isStatic() {
        return !isWildcard();
    }

    protected boolean isMultipart() {
        return multipart;
    }

    protected boolean isWildcard() {
        return wildcard;
    }

    protected int getRequired() {
        return required;
    }

    public String getName() {
        return name;
    }

    static ResourceUnit of(String name, int required) {
        boolean multipart = name.contains("*");

        if (multipart) {
            name = StringUtils.replace(name, "*", "");
        }

        return new ResourceUnit(name, required, name.startsWith("{"), multipart);
    }

}
