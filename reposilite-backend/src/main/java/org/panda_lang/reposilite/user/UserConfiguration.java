/*
 * Copyright (c) 2018-2019 Reposilite Team
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

package org.panda_lang.reposilite.user;

import org.panda_lang.reposilite.authentication.AuthenticationUserDetailsService;
import org.panda_lang.reposilite.authentication.userdetails.OAuth2UserDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
class UserConfiguration {

    @Bean
    AuthenticationUserDetailsService authenticationUserDetailsService(UserRepository userRepository) {
        return new UserDetailsService(userRepository);
    }

    @Bean
    OAuth2UserDetailsService defaultOAuth2UserService(UserRepository userRepository) {
        return new UserOAuth2DetailsService(userRepository);
    }

    @Bean
    UserFacade userFacade(PasswordEncoder passwordEncoder, UserRepository userRepository) {
        return new UserFacade(passwordEncoder, userRepository);
    }

}
