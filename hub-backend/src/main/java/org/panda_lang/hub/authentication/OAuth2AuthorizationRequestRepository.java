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

import org.panda_lang.hub.utils.helper.CookieHelper;
import org.springframework.security.oauth2.client.web.AuthorizationRequestRepository;
import org.springframework.security.oauth2.core.endpoint.OAuth2AuthorizationRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

class OAuth2AuthorizationRequestRepository implements AuthorizationRequestRepository<OAuth2AuthorizationRequest> {

    static final String REDIRECT_URI_COOKIE_NAME = "redirect_uri";
    private static final int COOKIE_EXPIRATION_TIME = 180;
    private static final String OAUTH_2_AUTHORIZATION_REQUEST_COOKIE_NAME = "oauth2_auth_request";

    @Override
    public OAuth2AuthorizationRequest loadAuthorizationRequest(HttpServletRequest request) {
        return CookieHelper.obtainCookie(OAUTH_2_AUTHORIZATION_REQUEST_COOKIE_NAME, request.getCookies())
                .map(cookie -> CookieHelper.deserialize(cookie, OAuth2AuthorizationRequest.class))
                .orElse(null);
    }

    @Override
    public OAuth2AuthorizationRequest removeAuthorizationRequest(HttpServletRequest request) {
        return this.loadAuthorizationRequest(request);
    }

    @Override
    public void saveAuthorizationRequest(OAuth2AuthorizationRequest authorizationRequest, HttpServletRequest servletRequest,
            HttpServletResponse servletResponse) {
        if (authorizationRequest == null) {
            this.removeAuthorizationRequestCookies(servletResponse, servletRequest);
            return;
        }

        String serializedCookie = CookieHelper.serialize(authorizationRequest);
        CookieHelper.appendCookie(OAUTH_2_AUTHORIZATION_REQUEST_COOKIE_NAME, serializedCookie, COOKIE_EXPIRATION_TIME, servletResponse);

        String redirectUri = servletRequest.getParameter(REDIRECT_URI_COOKIE_NAME);
        if (!redirectUri.isEmpty()) {
            CookieHelper.appendCookie(REDIRECT_URI_COOKIE_NAME, redirectUri, COOKIE_EXPIRATION_TIME, servletResponse);
        }
    }

    void removeAuthorizationRequestCookies(HttpServletResponse httpServletResponse, HttpServletRequest httpServletRequest) {
        CookieHelper.removeCookie(OAUTH_2_AUTHORIZATION_REQUEST_COOKIE_NAME, httpServletRequest, httpServletResponse);
        CookieHelper.removeCookie(REDIRECT_URI_COOKIE_NAME, httpServletRequest, httpServletResponse);
    }

}
