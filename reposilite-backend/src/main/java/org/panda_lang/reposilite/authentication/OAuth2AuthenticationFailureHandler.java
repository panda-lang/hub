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
