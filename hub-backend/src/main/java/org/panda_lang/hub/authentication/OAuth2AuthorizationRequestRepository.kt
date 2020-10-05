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

import org.panda_lang.hub.utils.helper.CookieHelper
import org.springframework.security.oauth2.client.web.AuthorizationRequestRepository
import org.springframework.security.oauth2.core.endpoint.OAuth2AuthorizationRequest
import javax.servlet.http.Cookie
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

internal class OAuth2AuthorizationRequestRepository : AuthorizationRequestRepository<OAuth2AuthorizationRequest?> {

    companion object {
        const val REDIRECT_URI_COOKIE_NAME = "redirect_uri"
        private const val COOKIE_EXPIRATION_TIME = 180
        private const val OAUTH_2_AUTHORIZATION_REQUEST_COOKIE_NAME = "oauth2_auth_request"
    }

    override fun loadAuthorizationRequest(request: HttpServletRequest): OAuth2AuthorizationRequest? {
        return CookieHelper.obtainCookie(OAUTH_2_AUTHORIZATION_REQUEST_COOKIE_NAME, request.cookies)
            .map { cookie: Cookie? -> CookieHelper.deserialize(cookie, OAuth2AuthorizationRequest::class.java) }
            .orElse(null)
    }

    override fun removeAuthorizationRequest(request: HttpServletRequest): OAuth2AuthorizationRequest? {
        return loadAuthorizationRequest(request)
    }

    override fun saveAuthorizationRequest(authorizationRequest: OAuth2AuthorizationRequest?, servletRequest: HttpServletRequest, servletResponse: HttpServletResponse) {
        if (authorizationRequest == null) {
            removeAuthorizationRequestCookies(servletResponse, servletRequest)
            return
        }

        val serializedCookie = CookieHelper.serialize(authorizationRequest)
        CookieHelper.appendCookie(OAUTH_2_AUTHORIZATION_REQUEST_COOKIE_NAME, serializedCookie, COOKIE_EXPIRATION_TIME, servletResponse)
        val redirectUri = servletRequest.getParameter(REDIRECT_URI_COOKIE_NAME)

        if (!redirectUri.isEmpty()) {
            CookieHelper.appendCookie(REDIRECT_URI_COOKIE_NAME, redirectUri, COOKIE_EXPIRATION_TIME, servletResponse)
        }
    }

    fun removeAuthorizationRequestCookies(httpServletResponse: HttpServletResponse, httpServletRequest: HttpServletRequest) {
        CookieHelper.removeCookie(OAUTH_2_AUTHORIZATION_REQUEST_COOKIE_NAME, httpServletRequest, httpServletResponse)
        CookieHelper.removeCookie(REDIRECT_URI_COOKIE_NAME, httpServletRequest, httpServletResponse)
    }
}
