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
import org.springframework.security.core.AuthenticationException
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler
import org.springframework.web.util.UriComponentsBuilder
import java.io.IOException
import javax.servlet.http.Cookie
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

internal class OAuth2AuthenticationFailureHandler(
        private val authorizationRequestRepository: OAuth2AuthorizationRequestRepository
) : SimpleUrlAuthenticationFailureHandler() {

    @Throws(IOException::class)
    override fun onAuthenticationFailure(servletRequest: HttpServletRequest, servletResponse: HttpServletResponse, authenticationException: AuthenticationException) {
        var redirectUri = CookieHelper.obtainCookie(OAuth2AuthorizationRequestRepository.REDIRECT_URI_COOKIE_NAME, servletRequest.cookies)
                .map { obj: Cookie? -> obj!!.value }
                .orElse("/")

        redirectUri = UriComponentsBuilder.fromUriString(redirectUri)
                .queryParam("error", authenticationException.localizedMessage)
                .build()
                .toUriString()

        authorizationRequestRepository.removeAuthorizationRequestCookies(servletResponse, servletRequest)
        redirectStrategy.sendRedirect(servletRequest, servletResponse, redirectUri)
    }

}