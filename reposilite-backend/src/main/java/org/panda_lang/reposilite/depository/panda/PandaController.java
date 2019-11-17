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

package org.panda_lang.reposilite.depository.panda;

import io.swagger.annotations.ApiOperation;
import org.panda_lang.reposilite.depository.AbstractSubServiceController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@ApiOperation("/api/repository/panda")
@RestController
class PandaController extends AbstractSubServiceController<PandaService> {

    @Autowired
    PandaController(PandaService pandaService) {
        super(pandaService);
    }

    @PutMapping("/**")
    public ResponseEntity<Object> put(@RequestBody Object object) throws IOException {
        System.out.println(object);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/**")
    public ResponseEntity<Object> get(HttpServletRequest request,  HttpServletResponse response) throws IOException {
        return super.getEntity(request, response);
    }

}
