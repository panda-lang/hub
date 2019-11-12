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

import org.panda_lang.reposilite.authentication.OAuth2UserDetails;
import org.panda_lang.reposilite.authentication.OAuth2UserDetailsFactory;
import org.panda_lang.reposilite.authentication.OAuth2UserDetailsService;
import org.panda_lang.utilities.commons.StringUtils;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;

import java.util.Optional;

class UserOAuth2DetailsService extends DefaultOAuth2UserService implements OAuth2UserDetailsService {

    private final UserRepository userRepository;

    UserOAuth2DetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
        OAuth2User user = super.loadUser(userRequest);

        try {
            return this.loadUser(userRequest, user);
        } catch (AuthenticationException exception) {
            throw exception;
        } catch (Exception exception) {
            throw new InternalAuthenticationServiceException(exception.getMessage(), exception.getCause());
        }
    }

    private OAuth2User loadUser(OAuth2UserRequest userRequest, OAuth2User oAuth2User) {
        String providerName = userRequest.getClientRegistration().getRegistrationId();
        OAuth2UserDetails userDetails = OAuth2UserDetailsFactory.obtainOAuth2UserDetails(providerName, oAuth2User.getAttributes());

        if (userDetails.getEmail() == null || userDetails.getEmail().isEmpty()) {
            throw new RuntimeException("There is no user with that email in provider's system");
        }

        Optional<User> optionalUser = this.userRepository.findByName(userDetails.getName());
        User user;

        if (optionalUser.isPresent()) {
            user = optionalUser.get();

            if (!providerName.equals(user.getProvider())) {
                throw new RuntimeException("Looks like you're already signed up with " + user.getProvider() + " account.");
            }

            user = this.updateExistingUser(user, userDetails);
        }
        else {
            user = this.createNewUser(userRequest, userDetails);
        }

        return UserDetails.of(user, oAuth2User.getAttributes());
    }

    private User createNewUser(OAuth2UserRequest userRequest, OAuth2UserDetails userDetails) {
        User user = User.builder()
                .withProvider(userRequest.getClientRegistration().getRegistrationId())
                .withProviderId(userDetails.getProviderId())
                .withPassword(StringUtils.EMPTY)
                .withName(userDetails.getName())
                .withDisplayName(userDetails.getDisplayName())
                .withEmail(userDetails.getEmail())
                .withAvatar(userDetails.getAvatar())
                .build();

        return this.userRepository.save(user);
    }

    private User updateExistingUser(User user, OAuth2UserDetails userDetails) {
        user.setName(userDetails.getName());
        user.setDisplayName(userDetails.getDisplayName());
        user.setAvatar(userDetails.getAvatar());

        return this.userRepository.save(user);
    }


}
