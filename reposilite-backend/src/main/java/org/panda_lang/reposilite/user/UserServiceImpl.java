package org.panda_lang.reposilite.user;

import org.panda_lang.panda.utilities.commons.collection.Sets;
import org.panda_lang.reposilite.auth.RegistrationForm;
import org.panda_lang.reposilite.user.role.Role;
import org.panda_lang.reposilite.user.role.RoleFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final RoleFactory roleFactory;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder, RoleFactory roleFactory) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.roleFactory = roleFactory;
    }

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        Optional<User> user = this.userRepository.findByName(name);

        if (!user.isPresent()) {
            throw new UsernameNotFoundException("No user found with that username.");
        }

        return new org.panda_lang.reposilite.user.UserDetails(user.get(), user.get().getName(), user.get().getPassword(), this.getAuthoritiesByRoles(user.get().getRoles()));
    }

    @Override
    public Optional<User> findByUsername(String name) {
        return this.userRepository.findByName(name);
    }

    @Override
    public User saveByForm(RegistrationForm form) {
        User user = new UserBuilder()
                .withName(form.getUsername())
                .withDisplayName(form.getDisplayName())
                .withPassword(this.passwordEncoder.encode(form.getPassword()))
                .withEmail(form.getEmail())
                .withRoles(Sets.newHashSet(this.roleFactory.obtainRole("USER")))
                .build();

        return this.userRepository.save(user);
    }

    private Set<? extends GrantedAuthority> getAuthoritiesByRoles(Set<Role> roles) {
        return roles.stream()
                .map(role -> new SimpleGrantedAuthority(role.getName()))
                .collect(Collectors.toSet());
    }

}
