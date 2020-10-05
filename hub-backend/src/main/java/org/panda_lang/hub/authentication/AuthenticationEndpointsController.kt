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
package org.panda_lang.hub.authentication

import org.panda_lang.hub.user.UserFacade
import org.springframework.http.ResponseEntity
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RequestMapping("/api/users")
@RestController
internal class AuthenticationEndpointsController(
    private val authenticationManager: AuthenticationManager,
    private val authenticationTokenCreator: AuthenticationTokenCreator,
    private val userFacade: UserFacade
) {

    @PostMapping("/signup")
    fun registerUser(@RequestBody dto: SignUpDto): ResponseEntity<*> {
        return ResponseEntity.created(userFacade.register(dto)).build<Any>()
    }

    @PostMapping("/signin")
    fun authenticateUser(@RequestBody dto: SignInDto): ResponseEntity<Map<String, Any?>> {
        val authentication = authenticationManager.authenticate(UsernamePasswordAuthenticationToken(dto.name, dto.password))
        SecurityContextHolder.getContext().authentication = authentication
        return ResponseEntity.ok(Collections.singletonMap<String, Any?>("access_token", authenticationTokenCreator.create(authentication)))
    }
}
