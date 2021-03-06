package org.panda_lang.hub.auth

import com.github.michaelbull.result.Result
import com.github.michaelbull.result.map
import io.ktor.auth.jwt.*
import org.panda_lang.hub.auth.jwt.JwtProvider
import org.panda_lang.hub.auth.jwt.getTokenClaim
import org.panda_lang.hub.failure.ErrorResponse
import org.panda_lang.hub.user.UserFacade
import java.util.*
import java.util.concurrent.ConcurrentHashMap

class AuthFacade internal constructor(
        private val provider: JwtProvider,
        private val userFacade: UserFacade
) {

    private val authenticated = ConcurrentHashMap.newKeySet<String>()

    internal suspend fun authenticate(oauthToken: String): Result<AuthResponse, ErrorResponse> {
        return userFacade.fetchUser(oauthToken).map {
            val token = provider.generateToken(oauthToken, it.id)

            authenticated.add(oauthToken)
            println(token)

            return@map AuthResponse(token, it)
        }
    }

    fun invalidateToken(credential: JWTCredential) =
            authenticated.remove(credential.getTokenClaim())

    fun isAuthenticated(credential: JWTCredential): Boolean =
            authenticated.contains(credential.getTokenClaim())

}