package org.panda_lang.reposilite.user;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.core.user.OAuth2User;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;

final class UserDetails extends org.springframework.security.core.userdetails.User implements OAuth2User {

    private final User user;
    private Map<String, Object> attributes;

    public UserDetails(User user, String username, String password, boolean enabled, boolean accountNonExpired, boolean credentialsNonExpired, boolean accountNonLocked, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
        this.user = user;
    }

    public UserDetails(User user, String username, String password, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, authorities);
        this.user = user;
    }

    public void setAttributes(Map<String, Object> attributes) {
        this.attributes = attributes;
    }

    @Override
    public Map<String, Object> getAttributes() {
        return attributes;
    }

    @Override
    public String getName() {
        return getName();
    }

    public User getUser() {
        return this.user;
    }

    static UserDetails of(User user) {
        return new UserDetails(user, user.getName(), user.getPassword(), Collections.singletonList(new SimpleGrantedAuthority("ROLE_USER")));
    }

    static UserDetails of(User user, Map<String, Object> attributes) {
        UserDetails userDetails = of(user);
        userDetails.setAttributes(attributes);

        return userDetails;
    }

}
