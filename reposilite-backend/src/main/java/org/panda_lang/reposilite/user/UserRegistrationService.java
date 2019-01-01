package org.panda_lang.reposilite.user;

import java.util.Optional;

public interface UserRegistrationService {

    Optional<User> findByUsername(String username);

    User save(User user);
}
