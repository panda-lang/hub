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

import org.panda_lang.hub.authentication.OAuth2UserDetails
import org.panda_lang.hub.authentication.OAuth2UserDetailsFactory
import org.panda_lang.hub.authentication.OAuth2UserDetailsService
import org.panda_lang.utilities.commons.StringUtils
import org.springframework.security.authentication.InternalAuthenticationServiceException
import org.springframework.security.core.AuthenticationException
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest
import org.springframework.security.oauth2.core.OAuth2AuthenticationException
import org.springframework.security.oauth2.core.user.OAuth2User

internal class UserOAuth2DetailsService(
        private val userRepository: UserRepository
) : DefaultOAuth2UserService(), OAuth2UserDetailsService {

    @Throws(OAuth2AuthenticationException::class)
    override fun loadUser(userRequest: OAuth2UserRequest?): OAuth2User {
        val user = super.loadUser(userRequest)

        return try {
            this.loadUser(userRequest!!, user)
        } catch (exception: AuthenticationException) {
            throw exception
        } catch (exception: Exception) {
            throw InternalAuthenticationServiceException(exception.message, exception.cause)
        }
    }

    private fun loadUser(userRequest: OAuth2UserRequest, oAuth2User: OAuth2User): OAuth2User {
        val providerName: String = userRequest.clientRegistration.registrationId
        val userDetails: OAuth2UserDetails = OAuth2UserDetailsFactory.obtainOAuth2UserDetails(providerName, oAuth2User.attributes)

        if (StringUtils.isEmpty(userDetails.email)) {
            throw RuntimeException("There is no user with that email in provider's system")
        }

        var user: User? = userRepository.findByName(userDetails.name)

        if (user != null ) {
            if (providerName != user.provider) {
                throw RuntimeException("Looks like you're already signed up with " + user.provider + " account.")
            }

            user = updateExistingUser(user, userDetails)
        } else {
            user = createNewUser(userRequest, userDetails)
        }

        return UserDetails.of(user, oAuth2User.attributes)
    }

    private fun createNewUser(userRequest: OAuth2UserRequest, userDetails: OAuth2UserDetails): User {
        val user = User(
                userDetails.name,
                userDetails.displayName ?: StringUtils.EMPTY,
                StringUtils.EMPTY,
                StringUtils.EMPTY,
                userDetails.email,
                userRequest.clientRegistration.registrationId,
                userDetails.providerId,
                userDetails.avatar ?: StringUtils.EMPTY,
                StringUtils.EMPTY,
                HashSet()
        )

        return userRepository.save(user)
    }

    private fun updateExistingUser(user: User, userDetails: OAuth2UserDetails): User {
        user.name = userDetails.name
        user.displayName = userDetails.displayName ?: StringUtils.EMPTY
        user.avatar = userDetails.avatar ?: StringUtils.EMPTY
        return userRepository.save(user)
    }

}