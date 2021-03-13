package org.panda_lang.hub.user

import kotlinx.serialization.Serializable
import org.panda_lang.hub.github.GitHubProfile

@Serializable
data class User(
    val id: Long,
    val profile: GitHubProfile
)
