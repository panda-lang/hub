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
package org.panda_lang.hub.user

import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.shell.standard.ShellComponent
import org.springframework.shell.standard.ShellMethod

@ShellComponent
internal class UserCommands(
        private val userRepository: UserRepository,
        private val passwordEncoder: PasswordEncoder
) {

    @ShellMethod(value = "Adds user", key = ["useradd"])
    fun addUserCommand(name: String): String {
        if (userRepository.existsByName(name)) {
            return "User already exists"
        }

        val user: User = userRepository.save(User(
                name,
                name,
                "",
                "",
                "",
                "",
                "",
                "",
                "",
                HashSet()
        ))

        return "Created user: " + user.name
    }

    @ShellMethod(value = "Sets user's password", key = ["passwd"])
    fun setPasswordCommand(name: String, password: String): String {
        val user = userRepository.findByName(name) ?: return "User not found!"

        user.password = passwordEncoder.encode(password)
        userRepository.save(user)

        return "Set password for user: $name"
    }

}