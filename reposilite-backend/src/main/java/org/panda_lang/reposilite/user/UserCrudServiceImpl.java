package org.panda_lang.reposilite.user;

import org.bson.types.ObjectId;
import org.panda_lang.panda.utilities.commons.collection.Sets;
import org.panda_lang.reposilite.user.role.RoleFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserCrudServiceImpl implements UserCrudService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final RoleFactory roleFactory;

    @Autowired
    public UserCrudServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder, RoleFactory roleFactory) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.roleFactory = roleFactory;
    }

    @Override
    public User save(User user) {
        user.setPassword(this.passwordEncoder.encode(user.getPassword()));
        user.setRoles(Sets.newHashSet(this.roleFactory.obtainRole("USER")));

        return this.userRepository.save(user);
    }

    @Override
    public Optional<User> findByName(String name) {
        return this.userRepository.findByName(name);
    }

    @Override
    public Optional<User> findById(ObjectId objectId) {
        return this.userRepository.findById(objectId);
    }

    @Override
    public List<User> findAll() {
        return this.userRepository.findAll();
    }

    @Override
    public void deleteById(ObjectId objectId) {
        this.userRepository.deleteById(objectId);
    }

    @Override
    public boolean existsById(ObjectId objectId) {
        return this.userRepository.existsById(objectId);
    }
}
