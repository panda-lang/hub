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
import org.panda_lang.reposilite.user.role.RoleFactory;
import org.panda_lang.reposilite.utils.entity.AbstractCrudOperationService;
import org.panda_lang.utilities.commons.collection.Sets;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
final class UserServiceImpl extends AbstractCrudOperationService<User, ObjectId> implements UserService {

    private final PasswordEncoder passwordEncoder;
    private final RoleFactory roleFactory;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder, RoleFactory roleFactory) {
        super(userRepository);
        this.passwordEncoder = passwordEncoder;
        this.roleFactory = roleFactory;
    }

    @Override
    public User save(User user) {
        user.setPassword(this.passwordEncoder.encode(user.getPassword()));
        user.setRoles(Sets.newHashSet(this.roleFactory.obtainRole("USER")));
        return super.getRepository().save(user);
    }

}
