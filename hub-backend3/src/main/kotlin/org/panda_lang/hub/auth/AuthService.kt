package org.panda_lang.hub.auth

import io.ktor.auth.*

class AuthService(val loginProviders: Map<String, OAuthServerSettings.OAuth2ServerSettings>) {

}