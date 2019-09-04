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

package org.panda_lang.reposilite;

import org.springframework.boot.SpringBootVersion;
import org.springframework.core.SpringVersion;

public final class ReposiliteConstants {

    public static final String REPOSILITE_VERSION = "indev-2018.12.30";

    public static final String SPRING_BOOT_VERSION = SpringBootVersion.getVersion();

    public static final String SPRING_VERSION = SpringVersion.getVersion();

    private ReposiliteConstants() { }

}
