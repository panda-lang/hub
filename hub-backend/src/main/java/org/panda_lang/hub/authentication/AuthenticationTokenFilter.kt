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

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.web.filter.OncePerRequestFilter
import javax.servlet.FilterChain
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

internal class AuthenticationTokenFilter(
    private val tokenProperties: AuthenticationProperties,
    private val tokenValidator: AuthenticationTokenValidator,
    private val tokenProvider: AuthenticationTokenProvider,
    private val userDetailsService: AuthenticationUserDetailsService
) : OncePerRequestFilter() {

    override fun doFilterInternal(request: HttpServletRequest, response: HttpServletResponse, filterChain: FilterChain) {
        val jwtToken = obtainJwtTokenFromRequest(request)
        val secretToken = tokenProperties.token.secret

        if (jwtToken != null && tokenValidator.validate(jwtToken, secretToken)) {
            val userId = tokenProvider.obtainUserId(jwtToken, secretToken)
            val userDetails = userDetailsService.loadUserById(userId)
            val authentication = UsernamePasswordAuthenticationToken(userDetails, null, userDetails.authorities)
            authentication.details = userDetails
            SecurityContextHolder.getContext().authentication = authentication
        }

        filterChain.doFilter(request, response)
    }

    private fun obtainJwtTokenFromRequest(servletRequest: HttpServletRequest): String? {
        val authorizationHeaderContent = servletRequest.getHeader("Authorization")
        val bearer = "Bearer "

        return if (authorizationHeaderContent != null && authorizationHeaderContent.startsWith(bearer)) {
            authorizationHeaderContent.substring(bearer.length)
        } else {
            null
        }
    }
}
