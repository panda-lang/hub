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

package org.panda_lang.hub.github

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import org.panda_lang.hub.user.Profile
import org.panda_lang.hub.user.UserInfo

@Serializable
data class GitHubUserInfo(
    override val id: Long,
    override val login: String,
    @SerialName("avatar_url")
    override val avatarUrl: String,
    override val type: String,
) : UserInfo

@Serializable
data class GitHubProfile(
    override val id: Long,
    override val login: String,
    @SerialName("avatar_url")
    override val avatarUrl: String,
    override val type: String,
    override val name: String,
    override val location: String,
    override val email: String,
    override val bio: String
) : Profile
