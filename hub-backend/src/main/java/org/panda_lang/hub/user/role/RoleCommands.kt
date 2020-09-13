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
package org.panda_lang.hub.user.role

import org.panda_lang.hub.user.UserRepository
import org.springframework.shell.standard.ShellComponent
import org.springframework.shell.standard.ShellMethod

@ShellComponent
internal class RoleCommands(
        private val roleRepository: RoleRepository,
        private val userRepository: UserRepository
) {

    @ShellMethod(value = "Lists all roles", key = ["roles"])
    fun roles(): String {
        return roleRepository.findAll()
                .filterNotNull()
                .joinToString { obj: Role -> obj.name }
    }

    @ShellMethod(value = "Sets role for the specified user", key = ["chrole"])
    fun setRole(username: String, role: String): String {
        val roleValue = roleRepository.findById(role)

        if (!roleValue.isPresent) {
            return "Role '$role' does not exist"
        }

        val user = userRepository.findByName(username) ?: return "User not found"

        user.addRole(roleValue.get())
        userRepository.save(user)

        return "Set role `$role` for user: $username"
    }
}