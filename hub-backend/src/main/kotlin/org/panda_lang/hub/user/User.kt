package org.panda_lang.hub.user

import kotlinx.serialization.Serializable
import org.panda_lang.hub.project.Package

@Serializable
data class User(
    val id: String,
    val username: String,
    val packages: Collection<Package>
)