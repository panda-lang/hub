/*
 * Copyright (c) 2018-2019 Hub Team
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

import org.panda_lang.hub.utils.converter.ObjectToMapConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class AuthenticationConfiguration {

    @Bean
    AuthenticationTokenCreator authenticationTokenCreator(AuthenticationProperties authenticationProperties) {
        return new AuthenticationTokenCreator(authenticationProperties, new ObjectToMapConverter());
    }

    @Bean
    OAuth2AuthorizationRequestRepository authorizationRequestRepository() {
        return new OAuth2AuthorizationRequestRepository();
    }

    @Bean
    AuthenticationTokenFilter authenticationTokenFilter(AuthenticationProperties tokenProperties, AuthenticationUserDetailsService userDetailsService) {
        AuthenticationTokenValidator tokenValidator = new AuthenticationTokenValidator();
        AuthenticationTokenProvider tokenProvider = new AuthenticationTokenProvider();

        return new AuthenticationTokenFilter(tokenProperties, tokenValidator, tokenProvider, userDetailsService);
    }

    @Bean
    OAuth2AuthenticationSuccessHandler oAuth2AuthenticationSuccessHandler(AuthenticationProperties authenticationProperties) {
        return new OAuth2AuthenticationSuccessHandler(authenticationTokenCreator(authenticationProperties), authenticationProperties, authorizationRequestRepository());
    }

    @Bean
    OAuth2AuthenticationFailureHandler oAuth2AuthenticationFailureHandler() {
        return new OAuth2AuthenticationFailureHandler(this.authorizationRequestRepository());
    }

}
