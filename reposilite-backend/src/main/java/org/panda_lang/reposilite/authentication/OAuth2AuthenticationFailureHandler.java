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

package org.panda_lang.reposilite.authentication;

import org.panda_lang.reposilite.utils.helper.CookieHelper;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

class OAuth2AuthenticationFailureHandler extends SimpleUrlAuthenticationFailureHandler {

    private final OAuth2AuthorizationRequestRepository authorizationRequestRepository;

    OAuth2AuthenticationFailureHandler(OAuth2AuthorizationRequestRepository authorizationRequestRepository) {
        this.authorizationRequestRepository = authorizationRequestRepository;
    }

    @Override
    public void onAuthenticationFailure(HttpServletRequest servletRequest, HttpServletResponse servletResponse, AuthenticationException authenticationException) throws IOException {
        String redirectUri = CookieHelper.obtainCookie(OAuth2AuthorizationRequestRepository.REDIRECT_URI_COOKIE_NAME, servletRequest.getCookies())
                .map(Cookie::getValue)
                .orElse(("/"));

        redirectUri = UriComponentsBuilder.fromUriString(redirectUri)
                .queryParam("error", authenticationException.getLocalizedMessage())
                .build()
                .toUriString();

        this.authorizationRequestRepository.removeAuthorizationRequestCookies(servletResponse, servletRequest);
        this.getRedirectStrategy().sendRedirect(servletRequest, servletResponse, redirectUri);
    }

}
