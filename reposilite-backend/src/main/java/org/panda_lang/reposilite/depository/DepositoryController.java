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

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@ApiOperation("/api/repositories")
@RestController
class DepositoryController {

    private final DepositoryService depositoryService;

    @Autowired
    DepositoryController(DepositoryService depositoryService) {
        this.depositoryService = depositoryService;
    }

    @GetMapping({ "/api/repositories", "/api/repository/" })
    ResponseEntity<Set<String>> repositories() {
        return ResponseEntity.ok(depositoryService.getSubServicesNames());
    }

}
