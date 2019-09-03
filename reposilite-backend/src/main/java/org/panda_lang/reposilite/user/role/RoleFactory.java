package org.panda_lang.reposilite.user.role;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public final class RoleFactory {

    private final RoleRepository roleRepository;

    @Autowired
    public RoleFactory(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public Role obtainRole(String roleName) {
        return this.roleRepository.findById(roleName).orElseGet(() -> this.roleRepository.save(new Role(roleName)));
    }

}
