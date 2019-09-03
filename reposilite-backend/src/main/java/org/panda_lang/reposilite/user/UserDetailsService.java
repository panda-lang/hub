package org.panda_lang.reposilite.user;

import org.bson.types.ObjectId;
import org.panda_lang.reposilite.authentication.AuthenticationUserDetailsService;
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
public final class UserDetailsService implements AuthenticationUserDetailsService {

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

        return toUserDetails(user.get());
    }

    @Override
    public UserDetails loadUserById(ObjectId id) {
        Optional<User> user = this.userRepository.findById(id);

        if (!user.isPresent()) {
            throw new UsernameNotFoundException("No user found with that id.");
        }

        return toUserDetails(user.get());
    }

    private Set<? extends GrantedAuthority> getAuthoritiesByRoles(Set<Role> roles) {
        return roles.stream()
                .map(role -> new SimpleGrantedAuthority(role.getName()))
                .collect(Collectors.toSet());
    }

    private UserDetails toUserDetails(User user) {
        return new UserDetails(user, user.getName(), user.getPassword(), this.getAuthoritiesByRoles(user.getRoles()));
    }

}
