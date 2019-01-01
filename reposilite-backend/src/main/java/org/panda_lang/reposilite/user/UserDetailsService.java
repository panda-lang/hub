package org.panda_lang.reposilite.user;

import org.panda_lang.reposilite.user.role.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {

    private final UserRepository userRepository;

    @Autowired
    public UserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        Optional<User> user = this.userRepository.findByName(name);

        if (!user.isPresent()) {
            throw new UsernameNotFoundException("No user found with that username.");
        }

        return new UserDetails(user.get(), user.get().getName(), user.get().getPassword(), this.getAuthoritiesByRoles(user.get().getRoles()));
    }

    private Set<? extends GrantedAuthority> getAuthoritiesByRoles(Set<Role> roles) {
        return roles.stream()
                .map(role -> new SimpleGrantedAuthority(role.getName()))
                .collect(Collectors.toSet());
    }

}
