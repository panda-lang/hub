package org.panda_lang.hub

import io.ktor.locations.*
import io.ktor.server.engine.*
import io.ktor.util.*
import java.security.Security

@EngineAPI
fun main() {
    System.setProperty("io.ktor.random.secure.random.provider", "DRBG")
    Security.setProperty("securerandom.drbg.config", "HMAC_DRBG,SHA-512,256,pr_and_reseed")

    setup().start(wait = true)
}