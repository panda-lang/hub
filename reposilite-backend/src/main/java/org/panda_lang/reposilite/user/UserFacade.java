package org.panda_lang.reposilite.user;

import org.panda_lang.reposilite.authentication.dto.SignUpDto;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

public class UserFacade {

    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    UserFacade(PasswordEncoder passwordEncoder, UserRepository userRepository) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
    }

    public URI register(SignUpDto dto) {
        if (this.userRepository.existsByName(dto.getName()) || this.userRepository.existsByEmail(dto.getEmail())) {
            throw new ResponseStatusException(HttpStatus.CONFLICT);
        }

        User user = this.userRepository.save(User.builder()
                .withName(dto.getName())
                .withDisplayName(dto.getDisplayName())
                .withEmail(dto.getEmail())
                .withPassword(this.passwordEncoder.encode(dto.getPassword()))
                .withProvider("local")
                .build());

        return ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/user/{id}").buildAndExpand(user.getIdentifier()).toUri();
    }

}
