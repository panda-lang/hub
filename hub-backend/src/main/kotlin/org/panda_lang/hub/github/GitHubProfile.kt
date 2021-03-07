package org.panda_lang.hub.github

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GitHubProfile(
    val id: Long,
    val login: String,
    @SerialName("avatar_url")
    val avatarUrl: String,
    val type: String,
    val name: String,
    val email: String
)