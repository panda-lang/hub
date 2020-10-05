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

import org.bson.types.ObjectId
import org.panda_lang.hub.user.role.RoleFactory
import org.panda_lang.hub.utils.entity.AbstractCrudOperationService
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service

@Service
internal class UserServiceImpl(
    userRepository: UserRepository,
    private val passwordEncoder: PasswordEncoder,
    private val roleFactory: RoleFactory
) : AbstractCrudOperationService<UserRepository, User, ObjectId?>(userRepository), UserService {

    override fun initializeUser(user: User): User {
        return save(user.apply {
            password = passwordEncoder.encode(user.password)
            addRole(roleFactory.obtainRole("USER"))
        })
    }
}
