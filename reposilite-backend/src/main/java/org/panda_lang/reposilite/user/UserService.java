package org.panda_lang.reposilite.user;

import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.Optional;

public interface UserService extends UserDetailsService {

    Optional<User> findByUsername(String name);

    User saveByForm(UserRegistrationForm form);

}
