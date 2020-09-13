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

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.core.annotation.Order
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.oauth2.client.registration.ClientRegistration
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository
import org.springframework.security.oauth2.client.registration.InMemoryClientRegistrationRepository
import org.springframework.security.oauth2.core.AuthorizationGrantType
import java.util.Collections
import java.util.List
import java.util.Objects
import java.util.stream.Collectors
import kotlin.Throws

@Configuration
@EnableWebSecurity
@Order(101)
class AuthenticationTestConfiguration : WebSecurityConfigurerAdapter() {
    @Bean
    fun clientRegistrationRepository(): ClientRegistrationRepository {
        val registrations: List<ClientRegistration> = CLIENTS.stream()
                .map { client: String -> getRegistration(client) }
                .filter(Objects::nonNull)
                .collect(Collectors.toList())
        return InMemoryClientRegistrationRepository(registrations)
    }

    private fun getRegistration(client: String): ClientRegistration {
        return ClientRegistration.withRegistrationId(client)
                .authorizationGrantType(AuthorizationGrantType.CLIENT_CREDENTIALS)
                .clientId("0")
                .clientName(client)
                .clientSecret("0")
                .tokenUri("unknown")
                .build()
    }

    companion object {
        private val CLIENTS: List<String> = Collections.singletonList("github")
    }
}