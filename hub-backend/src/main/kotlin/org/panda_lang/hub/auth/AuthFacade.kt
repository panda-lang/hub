package org.panda_lang.hub.auth

import io.ktor.auth.jwt.*
import org.panda_lang.hub.auth.jwt.JwtProvider
import org.panda_lang.hub.auth.jwt.OAUTH2_CLAIM
import org.panda_lang.hub.github.GitHubClient
import org.panda_lang.hub.github.GitHubUser
import org.panda_lang.hub.github.USER_INFO_URL
import org.panda_lang.hub.user.UserFacade

class AuthFacade internal constructor(
        private val provider: JwtProvider,
        private val userFacade: UserFacade
) {

    private val gitHubClient = GitHubClient()
    private val authenticated = HashSet<String>()

    suspend fun authenticate(oauthToken: String): AuthResponse {
        val userInfo = gitHubClient.request<GitHubUser>(USER_INFO_URL, oauthToken)
        val user = userFacade.fetchUser(userInfo)
        val token = provider.generateToken(oauthToken, user.id)

        authenticated.add(oauthToken)
        return AuthResponse(token, user)
    }

    fun invalidateToken(jwt: JWTCredential) =
            authenticated.remove(fetchOAuth2(jwt))

    fun isAuthenticated(jwt: JWTCredential): Boolean =
            authenticated.contains(fetchOAuth2(jwt))

    private fun fetchOAuth2(jwt: JWTCredential): String =
        jwt.payload.getClaim(OAUTH2_CLAIM).asString()

}