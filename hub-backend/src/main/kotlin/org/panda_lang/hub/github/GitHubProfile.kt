package org.panda_lang.hub.github

import kotlinx.serialization.Serializable

const val USER_PROFILE_INFO_URL = "https://api.github.com/user"

@Serializable
data class GitHubUser(
    val id: String,
    val login: String,
    val avatarUrl: String,
    val type: String,
    val name: String,
    val email: String
)