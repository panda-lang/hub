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

import org.panda_lang.reposilite.user.UserDetailsService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

    private final UserDetailsService userDetailsService;
    private final AuthenticationTokenFilter authenticationTokenFilter;
    private final OAuth2AuthorizationRequestRepository authorizationRequestRepository;
    private final OAuth2AuthenticationFailureHandler authenticationFailureHandler;
    private final OAuth2AuthenticationSuccessHandler authenticationSuccessHandler;
    private final OAuth2UserDetailsService oAuth2UserService;

    WebSecurityConfiguration(
            @Qualifier("authenticationUserDetailsService") UserDetailsService userDetailsService,
            AuthenticationTokenFilter authenticationTokenFilter,
            OAuth2AuthorizationRequestRepository authorizationRequestRepository,
            OAuth2AuthenticationFailureHandler authenticationFailureHandler,
            OAuth2AuthenticationSuccessHandler authenticationSuccessHandler,
            OAuth2UserDetailsService oAuth2UserService
    ) {
        this.userDetailsService = userDetailsService;
        this.authenticationTokenFilter = authenticationTokenFilter;
        this.authorizationRequestRepository = authorizationRequestRepository;
        this.authenticationFailureHandler = authenticationFailureHandler;
        this.authenticationSuccessHandler = authenticationSuccessHandler;
        this.oAuth2UserService = oAuth2UserService;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        AuthenticationEntryPoint authenticationEntryPoint = new AuthenticationEntryPoint();

        http.cors()
                .and().csrf().disable()
                .httpBasic().authenticationEntryPoint(authenticationEntryPoint)
                .and().formLogin().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and().exceptionHandling().authenticationEntryPoint(authenticationEntryPoint)
                .and().authorizeRequests().antMatchers("/auth/**", "/oauth2/**", "/api/tests/**").permitAll()
                .and().oauth2Login().authorizationEndpoint().baseUri("/oauth2/authorize").authorizationRequestRepository(this.authorizationRequestRepository)
                .and().redirectionEndpoint().baseUri("/oauth2/callback/*")
                .and().userInfoEndpoint().userService(this.oAuth2UserService)
                .and().successHandler(this.authenticationSuccessHandler).failureHandler(this.authenticationFailureHandler);

        http.addFilterBefore(this.authenticationTokenFilter, UsernamePasswordAuthenticationFilter.class);

        /* http.authorizeRequests()
                .antMatchers("/**").permitAll()
                .and().httpBasic() */
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(this.userDetailsService).passwordEncoder(passwordEncoder());
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
