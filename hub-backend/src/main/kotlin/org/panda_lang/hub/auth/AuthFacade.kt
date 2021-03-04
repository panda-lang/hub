package org.panda_lang.hub.auth

import io.ktor.auth.jwt.*
import org.panda_lang.hub.auth.jwt.JwtProvider
import org.panda_lang.hub.auth.jwt.getTokenClaim
import org.panda_lang.hub.github.GitHubClient
import org.panda_lang.hub.github.GitHubUser
import org.panda_lang.hub.github.USER_PROFILE_INFO_URL
import org.panda_lang.hub.user.UserFacade

class AuthFacade internal constructor(
        private val provider: JwtProvider,
        private val userFacade: UserFacade
) {

    private val gitHubClient = GitHubClient()
    private val authenticated = HashSet<String>()

    internal suspend fun authenticate(oauthToken: String): AuthResponse {
        val userInfo = gitHubClient.request<GitHubUser>(USER_PROFILE_INFO_URL, oauthToken)
        val user = userFacade.fetchUser(userInfo)
        
        val token = provider.generateToken(oauthToken, user.id)
        println(token)

        authenticated.add(oauthToken)
        return AuthResponse(token, user)
    }

    fun invalidateToken(credential: JWTCredential) =
            authenticated.remove(credential.getTokenClaim())

    fun isAuthenticated(credential: JWTCredential): Boolean =
            authenticated.contains(credential.getTokenClaim())

}