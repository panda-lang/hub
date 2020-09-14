/*
 * Copyright (c) 2020 Hub Team of panda-lang organization
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
package org.panda_lang.hub.project

import org.bson.types.ObjectId
import org.panda_lang.hub.utils.entity.AbstractCrudOperationService
import org.panda_lang.hub.utils.entity.CrudOperationsService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

@Service
internal open class ProjectService(
        projectRepository: ProjectRepository
) : AbstractCrudOperationService<ProjectRepository, Project, ObjectId?>(projectRepository), CrudOperationsService<Project, ObjectId?> {

    fun findAllByOwnerName(name: String?): List<Project?>? {
        return super.repository.findAllByOwnerName(name)
    }

    fun findAll(pageable: Pageable): Page<Project?> {
        return super.repository.findAll(pageable)
    }

    fun count(): Long {
        return super.repository.count()
    }

}