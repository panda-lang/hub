/*
 * Copyright (c) 2018-2019 Reposilite Team
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

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
final class UserCrudServiceImpl implements UserCrudService {

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
