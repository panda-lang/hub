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
import org.springframework.http.HttpStatus
import org.springframework.security.core.Authentication
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler
import org.springframework.web.server.ResponseStatusException
import org.springframework.web.util.UriComponentsBuilder
import java.io.IOException
import java.net.URI
import javax.servlet.http.Cookie
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

internal class OAuth2AuthenticationSuccessHandler(
        private val tokenCreator: AuthenticationTokenCreator,
        private val tokenProperties: AuthenticationProperties,
        private val requestRepository: OAuth2AuthorizationRequestRepository
) : SimpleUrlAuthenticationSuccessHandler() {

    @Throws(IOException::class)
    override fun onAuthenticationSuccess(servletRequest: HttpServletRequest, servletResponse: HttpServletResponse, authentication: Authentication) {
        if (!servletResponse.isCommitted) {
            val redirectUrl = obtainRedirectUri(authentication, servletRequest)
            this.clearAuthenticationAttributes(servletRequest, servletResponse)
            redirectStrategy.sendRedirect(servletRequest, servletResponse, redirectUrl)
        }
    }

    private fun obtainRedirectUri(authentication: Authentication, servletRequest: HttpServletRequest): String {
        val optionalRedirectUrl = CookieHelper.obtainCookie(OAuth2AuthorizationRequestRepository.REDIRECT_URI_COOKIE_NAME, servletRequest.cookies)
                .map { obj: Cookie? -> obj!!.value }

        if (optionalRedirectUrl.isPresent && !isAuthorizedRedirectUri(optionalRedirectUrl.get())) {
            throw ResponseStatusException(HttpStatus.BAD_REQUEST, "Sorry! We've got an Unauthorized Redirect URI and can't proceed with the authentication")
        }

        val redirectUrl = optionalRedirectUrl.orElse(defaultTargetUrl)
        val token = tokenCreator.create(authentication)

        return UriComponentsBuilder.fromUriString(redirectUrl).queryParam("token", token).build().toUriString()
    }

    private fun isAuthorizedRedirectUri(uri: String): Boolean {
        val clientRedirectUri = URI.create(uri)

        return tokenProperties.oauth.redirectUrls.stream()
                .anyMatch { redirectUri: String? ->
                    val authorizedUri = URI.create(redirectUri)
                    clientRedirectUri.host.equals(authorizedUri.host, ignoreCase = true) && authorizedUri.port == clientRedirectUri.port
                }
    }

    private fun clearAuthenticationAttributes(servletRequest: HttpServletRequest, servletResponse: HttpServletResponse) {
        super.clearAuthenticationAttributes(servletRequest)
        requestRepository.removeAuthorizationRequestCookies(servletResponse, servletRequest)
    }

}