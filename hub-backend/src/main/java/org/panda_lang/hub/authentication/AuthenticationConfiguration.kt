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

import org.panda_lang.hub.utils.converter.ObjectToMapConverter
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
internal open class AuthenticationConfiguration {

    @Bean
    open fun authenticationTokenCreator(authenticationProperties: AuthenticationProperties): AuthenticationTokenCreator {
        return AuthenticationTokenCreator(authenticationProperties, ObjectToMapConverter())
    }

    @Bean
    open fun authorizationRequestRepository(): OAuth2AuthorizationRequestRepository {
        return OAuth2AuthorizationRequestRepository()
    }

    @Bean
    open fun authenticationTokenFilter(tokenProperties: AuthenticationProperties, userDetailsService: AuthenticationUserDetailsService): AuthenticationTokenFilter {
        val tokenValidator = AuthenticationTokenValidator()
        val tokenProvider = AuthenticationTokenProvider()
        return AuthenticationTokenFilter(tokenProperties, tokenValidator, tokenProvider, userDetailsService)
    }

    @Bean
    open fun oAuth2AuthenticationSuccessHandler(authenticationProperties: AuthenticationProperties): OAuth2AuthenticationSuccessHandler {
        return OAuth2AuthenticationSuccessHandler(authenticationTokenCreator(authenticationProperties), authenticationProperties, authorizationRequestRepository())
    }

    @Bean
    open fun oAuth2AuthenticationFailureHandler(): OAuth2AuthenticationFailureHandler {
        return OAuth2AuthenticationFailureHandler(authorizationRequestRepository())
    }

}