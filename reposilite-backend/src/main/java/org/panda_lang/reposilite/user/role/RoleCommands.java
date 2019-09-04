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

package org.panda_lang.reposilite.user.role;

import org.panda_lang.reposilite.user.User;
import org.panda_lang.reposilite.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

import java.util.stream.Collectors;

@ShellComponent
final class RoleCommands {

    private final RoleFactory roleFactory;
    private final RoleRepository roleRepository;
    private final UserRepository userRepository;

    @Autowired
    public RoleCommands(RoleFactory roleFactory, RoleRepository roleRepository, UserRepository userRepository) {
        this.roleFactory = roleFactory;
        this.roleRepository = roleRepository;
        this.userRepository = userRepository;
    }

    @ShellMethod(value = "Lists all roles", key = "roles")
    public String roles() {
        return this.roleRepository.findAll().stream()
                .map(Role::getName)
                .collect(Collectors.joining(", "));
    }

    @ShellMethod(value = "Sets role for the specified user", key = "chrole")
    public String setRole(String username, String role) {
        if (this.userRepository.existsByName(username)) {
            User user = this.userRepository.findByName(username).get();
            user.addRole(this.roleFactory.obtainRole(role));

            this.userRepository.save(user);
            return "Set role `" + role + "` for user: " + username;
        }

        return "User not found!";
    }

}
