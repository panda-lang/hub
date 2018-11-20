package org.panda_lang.reposilite.user;

import org.panda_lang.reposilite.auth.RegistrationForm;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.Optional;

public interface UserService extends UserDetailsService {

    Optional<User> findByUsername(String name);

    User saveByForm(RegistrationForm form);

}
