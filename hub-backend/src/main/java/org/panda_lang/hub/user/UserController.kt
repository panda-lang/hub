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

import io.swagger.annotations.ApiOperation
import org.bson.types.ObjectId
import org.panda_lang.hub.utils.entity.AbstractCrudController
import org.springframework.http.ResponseEntity
import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@ApiOperation("Operations pertaining to user")
@RestController
@RequestMapping("/api/users")
internal open class UserController(
    service: UserService
) : AbstractCrudController<UserService, User, ObjectId?, UserUpdateDto, UserRegistrationDto>(service) {

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/me")
    fun me(@AuthenticatedUser user: UserDetails): ResponseEntity<User?> {
        return ResponseEntity.ok(user.user)
    }
}
