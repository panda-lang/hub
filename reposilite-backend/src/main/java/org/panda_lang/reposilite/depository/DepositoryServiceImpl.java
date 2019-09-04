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

package org.panda_lang.reposilite.depository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

@Service
final class DepositoryServiceImpl implements DepositoryService {

    private final Map<String, DepositorySubService> subServiceMap;

    @Autowired
    protected DepositoryServiceImpl(List<DepositorySubService> subServices) {
        this.subServiceMap = new HashMap<>(subServices.size());

        for (DepositorySubService subService : subServices) {
            subServiceMap.put(subService.getName().toLowerCase(), subService);
        }
    }

    @Override
    public Optional<DepositorySubService> getSubService(String subServiceName) {
        return Optional.ofNullable(subServiceMap.get(subServiceName.toLowerCase()));
    }

    @Override
    public Set<String> getSubServicesNames() {
        return subServiceMap.keySet();
    }

}
