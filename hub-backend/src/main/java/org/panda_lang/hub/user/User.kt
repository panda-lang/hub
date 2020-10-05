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
package org.panda_lang.hub.user

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.databind.annotation.JsonSerialize
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer
import org.bson.types.ObjectId
import org.panda_lang.hub.user.role.Role
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document("users")
data class User internal constructor(
    override var name: String,
    override var displayName: String?,
    @field:JsonIgnore
    var password: String,
    override var description: String?,
    override var email: String,
    var provider: String,
    var providerId: String,
    override var avatar: String,
    override var site: String?,
    private var roles: MutableSet<Role>
) : Owner {

    @Id
    @JsonSerialize(using = ToStringSerializer::class)
    override var identifier: ObjectId? = null

    fun getRoles(): Set<Role?> {
        return roles
    }

    fun addRole(role: Role) {
        roles.add(role)
    }
}
