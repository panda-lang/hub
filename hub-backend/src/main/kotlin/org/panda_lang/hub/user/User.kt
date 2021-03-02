package org.panda_lang.hub.user

import kotlinx.serialization.Serializable

@Serializable
data class User(
    val id: String,
    val username: String
)