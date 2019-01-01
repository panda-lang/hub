package org.panda_lang.reposilite.user;

import org.panda_lang.panda.utilities.commons.collection.Sets;
import org.panda_lang.reposilite.user.role.RoleFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserRegistrationServiceImpl implements UserRegistrationService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final RoleFactory roleFactory;

    @Autowired
    public UserRegistrationServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder, RoleFactory roleFactory) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.roleFactory = roleFactory;
    }

    @Override
    public Optional<User> findByUsername(String username) {
        return this.userRepository.findByName(username);
    }

    @Override
    public User save(User user) {
        user.setPassword(this.passwordEncoder.encode(user.getPassword()));
        user.setRoles(Sets.newHashSet(this.roleFactory.obtainRole("USER")));

        return this.userRepository.save(user);
    }

}
