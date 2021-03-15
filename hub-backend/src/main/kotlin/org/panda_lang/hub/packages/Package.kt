package org.panda_lang.hub.packages

import kotlinx.serialization.Serializable

@Serializable
data class Package(
    val id: Long,
    val name: String,
    val owner: String,
    val registered: Boolean
)
