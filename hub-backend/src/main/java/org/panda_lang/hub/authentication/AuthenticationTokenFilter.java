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

import org.bson.types.ObjectId;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

class AuthenticationTokenFilter extends OncePerRequestFilter {

    private final AuthenticationProperties tokenProperties;
    private final AuthenticationTokenValidator tokenValidator;
    private final AuthenticationTokenProvider tokenProvider;
    private final AuthenticationUserDetailsService userDetailsService;

    AuthenticationTokenFilter(
            AuthenticationProperties tokenProperties,
            AuthenticationTokenValidator tokenValidator,
            AuthenticationTokenProvider tokenProvider,
            AuthenticationUserDetailsService userDetailsService
    ) {
        this.tokenProperties = tokenProperties;
        this.tokenValidator = tokenValidator;
        this.tokenProvider = tokenProvider;
        this.userDetailsService = userDetailsService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        String jwtToken = this.obtainJwtTokenFromRequest(request);
        String secretToken = this.tokenProperties.getToken().getSecret();

        if (jwtToken != null && this.tokenValidator.validate(jwtToken, secretToken)) {
            ObjectId userId = this.tokenProvider.obtainUserId(jwtToken, secretToken);
            UserDetails userDetails = this.userDetailsService.loadUserById(userId);

            UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
            authentication.setDetails(userDetails);

            SecurityContextHolder.getContext().setAuthentication(authentication);
        }

        filterChain.doFilter(request, response);
    }

    private String obtainJwtTokenFromRequest(HttpServletRequest servletRequest) {
        String authorizationHeaderContent = servletRequest.getHeader("Authorization");
        String bearer = "Bearer ";

        if (authorizationHeaderContent != null && authorizationHeaderContent.startsWith(bearer)) {
            return authorizationHeaderContent.substring(bearer.length());
        }

        return null;
    }

}
