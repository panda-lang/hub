package org.panda_lang.hub.auth

import com.auth0.jwt.algorithms.Algorithm

internal data class JwtConfiguration(
    val issuer: String,
    val audience: String,
    val realm: String,
    val ttl: Long,
    val algorithm: Algorithm
)