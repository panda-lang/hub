package org.panda_lang.hub

import io.ktor.locations.*
import io.ktor.server.engine.*
import io.ktor.util.*

@KtorExperimentalLocationsAPI
@KtorExperimentalAPI
@EngineAPI
fun main() {
    setup().start(wait = true)
}