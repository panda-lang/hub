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

@Serializable
data class GitHubRepositoryInfo(
    val id: Long,
    val name: String,
    @SerialName("full_name")
    val fullName: String,
    val owner: GitHubUserInfo
) {

    fun toId() = RepositoryId(owner.login, name)

}

data class RepositoryId(
    val login: String,
    val name: String
) {

    fun fullName() = "$login/$name"

}
