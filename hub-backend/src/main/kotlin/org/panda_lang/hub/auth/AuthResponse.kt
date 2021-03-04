package org.panda_lang.hub.auth

import kotlinx.serialization.Serializable
import org.panda_lang.hub.user.User

@Serializable
internal data class AuthResponse(
    val jwt: String,
    val user: User
)