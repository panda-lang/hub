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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

final class ReposiliteLogger {

    static final Logger REPOSILITE_LOGGER = LoggerFactory.getLogger("Reposilite");

    private static final String ASCII_LOGO = "\n" +
            "  _____                           _  _  _  _        \n" +
            " |  __ \\                         (_)| |(_)| |       \n" +
            " | |__) | ___  _ __    ___   ___  _ | | _ | |_  ___ \n" +
            " |  _  / / _ \\| '_ \\  / _ \\ / __|| || || || __|/ _ \\\n" +
            " | | \\ \\|  __/| |_) || (_) |\\__ \\| || || || |_|  __/\n" +
            " |_|  \\_\\\\___|| .__/  \\___/ |___/|_||_||_| \\__|\\___|\n" +
            "              | |                                   \n" +
            "              |_|                                   \n";

    static void initializeMessage() {
        if (Thread.currentThread().getName().contains("restarted")) {
            return;
        }

        System.out.println(ReposiliteLogger.ASCII_LOGO);
        System.out.println(" Version: " + ReposiliteConstants.REPOSILITE_VERSION);
        System.out.println(" Spring: " + ReposiliteConstants.SPRING_VERSION);
        System.out.println(" Spring Boot: " + ReposiliteConstants.SPRING_BOOT_VERSION);
        System.out.println();
    }

    private ReposiliteLogger() { }

}
