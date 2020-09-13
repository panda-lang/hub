/*
 * Copyright (c) 2020 Hub Team of panda-lang organization
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
package org.panda_lang.hub

import org.slf4j.Logger
import org.slf4j.LoggerFactory

internal object HubLogger {

    val REPOSILITE_LOGGER: Logger = LoggerFactory.getLogger("Hub")

    fun initializeMessage () {
        if (Thread.currentThread().name.contains("restarted")) {
            return
        }

        println(" Version: " + HubConstants.REPOSILITE_VERSION)
        println(" Spring: " + HubConstants.SPRING_VERSION)
        println(" Spring Boot: " + HubConstants.SPRING_BOOT_VERSION)
        println()
    }

}