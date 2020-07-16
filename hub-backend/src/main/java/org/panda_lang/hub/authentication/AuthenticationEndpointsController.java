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

package org.panda_lang.hub.authentication;

import org.panda_lang.hub.user.UserFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Map;

@RequestMapping("/api/users")
@RestController
class AuthenticationEndpointsController {

    private final AuthenticationManager authenticationManager;
    private final AuthenticationTokenCreator authenticationTokenCreator;
    private final UserFacade userFacade;

    @Autowired
    AuthenticationEndpointsController(AuthenticationManager authenticationManager, AuthenticationTokenCreator authenticationTokenCreator, UserFacade userFacade) {
        this.authenticationManager = authenticationManager;
        this.authenticationTokenCreator = authenticationTokenCreator;
        this.userFacade = userFacade;
    }

    @PostMapping("/signup")
    ResponseEntity<?> registerUser(@RequestBody SignUpDto dto) {
        return ResponseEntity.created(this.userFacade.register(dto)).build();
    }

    @PostMapping("/signin")
    ResponseEntity<Map<String, Object>> authenticateUser(@RequestBody SignInDto dto) {
        Authentication authentication = this.authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(dto.getName(), dto.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);

        return ResponseEntity.ok(Collections.singletonMap("access_token", this.authenticationTokenCreator.create(authentication)));
    }

}
