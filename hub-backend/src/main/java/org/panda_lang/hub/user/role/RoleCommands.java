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

package org.panda_lang.hub.user.role;

import org.panda_lang.hub.user.User;
import org.panda_lang.hub.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

import java.util.Optional;
import java.util.stream.Collectors;

@ShellComponent
final class RoleCommands {

    private final RoleRepository roleRepository;
    private final UserRepository userRepository;

    @Autowired
    public RoleCommands(RoleRepository roleRepository, UserRepository userRepository) {
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
        Optional<Role> roleValue = this.roleRepository.findById(role);

        if (!roleValue.isPresent()) {
            return "Role '" + role + "' does not exist";
        }

        Optional<User> userValue = this.userRepository.findByName(username);

        if (!userValue.isPresent()) {
            return "User not found";
        }

        userValue.ifPresent(user -> {
            user.addRole(roleValue.get());
            userRepository.save(user);
        });

        return "Set role `" + role + "` for user: " + username;
    }

}
