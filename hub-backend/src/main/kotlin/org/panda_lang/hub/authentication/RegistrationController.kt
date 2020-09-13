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

import io.swagger.annotations.ApiOperation
import io.swagger.annotations.ApiResponse
import io.swagger.annotations.ApiResponses
import org.panda_lang.hub.user.User
import org.panda_lang.hub.user.UserRegistrationDto
import org.panda_lang.hub.user.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.validation.BindingResult
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

@ApiOperation("Operations pertaining to registration")
@RestController
@RequestMapping("api/register")
internal class RegistrationController @Autowired constructor(private val userService: UserService) {

    @ApiOperation(value = "Register a user account")
    @ApiResponses(
            ApiResponse(code = 409, message = "User with that username already exists"),
            ApiResponse(code = 400, message = "Bad Request"),
            ApiResponse(code = 201, message = "Successfully created user", response = User::class)
    )
    @PostMapping
    fun register(@RequestBody dto: @Valid UserRegistrationDto, result: BindingResult): ResponseEntity<*> {
        var user: User? = userService.findByName(dto.name)

        user?.let {
            return ResponseEntity.status(HttpStatus.CONFLICT).build<Any>()
        }

        if (result.hasErrors()) {
            return ResponseEntity.badRequest().build<Any>()
        }

        user = userService.initializeUser(dto.toEntity())

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(user)
    }

}