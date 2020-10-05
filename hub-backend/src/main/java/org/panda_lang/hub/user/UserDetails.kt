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

import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.oauth2.core.user.OAuth2User

class UserDetails : org.springframework.security.core.userdetails.User, OAuth2User {
    val user: User
    private var attributes: Map<String, Any>? = null

    constructor(user: User, username: String?, password: String?, enabled: Boolean, accountNonExpired: Boolean, credentialsNonExpired: Boolean, accountNonLocked: Boolean, authorities: Collection<GrantedAuthority?>?) : super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities) {
        this.user = user
    }

    constructor(user: User, username: String?, password: String?, authorities: Collection<GrantedAuthority?>?) : super(username, password, authorities) {
        this.user = user
    }

    fun setAttributes(attributes: Map<String, Any>?) {
        this.attributes = attributes
    }

    override fun getAttributes(): Map<String, Any> {
        return attributes!!
    }

    override fun getName(): String {
        return user.identifier!!.toHexString()
    }

    companion object {
        fun of(user: User): UserDetails {
            return UserDetails(user, user.name, user.password, listOf(SimpleGrantedAuthority("ROLE_USER")))
        }

        fun of(user: User, attributes: Map<String, Any>?): UserDetails {
            val userDetails = of(user)
            userDetails.setAttributes(attributes)
            return userDetails
        }
    }
}
