package org.panda_lang.hub.project

import kotlinx.serialization.Serializable

@Serializable
data class Package(
    val name: String,
    val owner: String,
    val registered: Boolean
)
