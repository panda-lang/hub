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

import org.panda_lang.hub.authentication.SignUpDto;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

public class UserFacade {

    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    UserFacade(PasswordEncoder passwordEncoder, UserRepository userRepository) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
    }

    public URI register(SignUpDto dto) {
        if (this.userRepository.existsByName(dto.getName()) || this.userRepository.existsByEmail(dto.getEmail())) {
            throw new ResponseStatusException(HttpStatus.CONFLICT);
        }

        User user = this.userRepository.save(User.builder()
                .withName(dto.getName())
                .withDisplayName(dto.getDisplayName())
                .withEmail(dto.getEmail())
                .withPassword(this.passwordEncoder.encode(dto.getPassword()))
                .withProvider("local")
                .build());

        return ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/user/{id}").buildAndExpand(user.getIdentifier()).toUri();
    }

}
