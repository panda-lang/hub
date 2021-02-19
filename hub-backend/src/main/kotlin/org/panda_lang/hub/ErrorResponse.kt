package org.panda_lang.hub

import kotlinx.serialization.Serializable

@Serializable
data class ErrorResponse(
    val message: String
)