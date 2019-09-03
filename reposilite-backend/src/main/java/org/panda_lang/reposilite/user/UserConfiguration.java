package org.panda_lang.reposilite.user;

import org.panda_lang.reposilite.authentication.AuthenticationUserDetailsService;
import org.panda_lang.reposilite.authentication.userdetails.OAuth2UserDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
class UserConfiguration {

    @Bean
    AuthenticationUserDetailsService authenticationUserDetailsService(UserRepository userRepository) {
        return new UserDetailsService(userRepository);
    }

    @Bean
    OAuth2UserDetailsService defaultOAuth2UserService(UserRepository userRepository) {
        return new UserOAuth2DetailsService(userRepository);
    }

    @Bean
    UserFacade userFacade(PasswordEncoder passwordEncoder, UserRepository userRepository) {
        return new UserFacade(passwordEncoder, userRepository);
    }

}
