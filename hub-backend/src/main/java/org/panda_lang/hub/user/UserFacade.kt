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

import org.panda_lang.hub.authentication.SignUpDto
import org.springframework.http.HttpStatus
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.web.server.ResponseStatusException
import org.springframework.web.servlet.support.ServletUriComponentsBuilder
import java.net.URI

class UserFacade internal constructor(
    private val passwordEncoder: PasswordEncoder,
    private val userRepository: UserRepository
) {

    fun register(dto: SignUpDto): URI {
        if (userRepository.existsByName(dto.name) || userRepository.existsByEmail(dto.email)) {
            throw ResponseStatusException(HttpStatus.CONFLICT)
        }

        val user = userRepository.save(
            User(
                dto.name,
                dto.displayName,
                passwordEncoder.encode(dto.password),
                "",
                dto.email,
                "local",
                "",
                "",
                "",
                HashSet()
            )
        )

        return ServletUriComponentsBuilder
            .fromCurrentContextPath()
            .path("/api/user/{id}")
            .buildAndExpand(user.identifier)
            .toUri()
    }
}
