package org.panda_lang.hub.github

import kotlinx.serialization.Serializable

@Serializable
data class GitHubProfile(
    val id: String,
    val login: String,
    val avatarUrl: String,
    val type: String,
    val name: String,
    val email: String
)