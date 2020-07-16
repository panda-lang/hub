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

package org.panda_lang.hub.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

import java.util.Collections;
import java.util.Optional;

@ShellComponent
final class UserCommands {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserCommands(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @ShellMethod(value = "Adds user", key = "useradd")
    public String addUserCommand(String name) {
        if (!this.userRepository.existsByName(name)) {
            User user = new UserBuilder().withName(name).withRoles(Collections.emptySet()).build();
            this.userRepository.save(user);

            return "Created user: " + user.getName();
        }

        return "User already exists";
    }

    @ShellMethod(value = "Sets user's password", key = "passwd")
    public String setPasswordCommand(String name, String password) {
        Optional<User> user = this.userRepository.findByName(name);

        if (!user.isPresent()) {
            return "User not found!";
        }

        user.get().setPassword(this.passwordEncoder.encode(password));
        this.userRepository.save(user.get());

        return "Set password for user: " + name;
    }

}
