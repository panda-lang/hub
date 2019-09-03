package org.panda_lang.reposilite.user.role;

import org.panda_lang.reposilite.user.User;
import org.panda_lang.reposilite.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

import java.util.stream.Collectors;

@ShellComponent
final class RoleCommands {

    private final RoleFactory roleFactory;
    private final RoleRepository roleRepository;
    private final UserRepository userRepository;

    @Autowired
    public RoleCommands(RoleFactory roleFactory, RoleRepository roleRepository, UserRepository userRepository) {
        this.roleFactory = roleFactory;
        this.roleRepository = roleRepository;
        this.userRepository = userRepository;
    }

    @ShellMethod(value = "Lists all roles", key = "roles")
    public String roles() {
        return this.roleRepository.findAll().stream()
                .map(Role::getName)
                .collect(Collectors.joining(", "));
    }

    @ShellMethod(value = "Sets role for the specified user", key = "chrole")
    public String setRole(String username, String role) {
        if (this.userRepository.existsByName(username)) {
            User user = this.userRepository.findByName(username).get();
            user.addRole(this.roleFactory.obtainRole(role));

            this.userRepository.save(user);
            return "Set role `" + role + "` for user: " + username;
        }

        return "User not found!";
    }

}
