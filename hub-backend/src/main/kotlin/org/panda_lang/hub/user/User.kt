/*
 * Copyright (c) 2021 Hub Team of panda-lang organization
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

import kotlinx.serialization.Contextual
import kotlinx.serialization.Serializable

@Serializable
data class User(
    @Contextual
    val _id: String,
    val profile: Profile
)

interface UserInfo {
    val id: Long
    val login: String
    val avatarUrl: String
    val type: String
}

interface Profile : UserInfo {
    val name: String
    val location: String
    val email: String
    val bio: String
}
