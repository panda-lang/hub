package org.panda_lang.reposilite.user.role;

import org.panda_lang.panda.utilities.commons.collection.Sets;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
final class RoleInitializer implements ApplicationListener<ContextRefreshedEvent> {

    private final RoleRepository roleRepository;

    public RoleInitializer(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        this.roleRepository.saveAll(Sets.newHashSet(
                new Role("USER"),
                new Role("ADMIN"),
                new Role("MOD"),
                new Role("BOT"))
        );
    }

}
