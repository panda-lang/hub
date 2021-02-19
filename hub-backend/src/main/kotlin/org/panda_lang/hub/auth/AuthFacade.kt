package org.panda_lang.hub.auth

import com.auth0.jwt.JWT
import io.ktor.auth.jwt.*
import io.ktor.client.*
import io.ktor.client.features.json.*
import io.ktor.client.request.*
import io.ktor.http.*
import org.panda_lang.hub.github.GitHubUser
import org.panda_lang.hub.github.USER_INFO_URL
import org.panda_lang.hub.user.UserFacade
import java.util.*
import kotlin.collections.HashSet

class AuthFacade internal constructor(
    private val jwtConfiguration: JwtConfiguration,
    private val userFacade: UserFacade
) {

    private val authenticated = HashSet<String>()

    private val githubClient = HttpClient {
        install(JsonFeature) {
            accept(ContentType.Application.Json)
        }
    }

    suspend fun authenticate(oauthToken: String): AuthResponse {
        val userInfo = requestGitHubApi<GitHubUser>(USER_INFO_URL, oauthToken)
        val user = userFacade.fetchUser(userInfo)

        val jwtToken = JWT.create()
            .withSubject("Authentication")
            .withIssuer(jwtConfiguration.issuer)
            .withAudience(jwtConfiguration.audience)
            .withClaim(OAUTH2_CLAIM, oauthToken)
            .withClaim(ID_CLAIM, userInfo.id)
            .withClaim(NAME_CLAIM, userInfo.login)
            .withExpiresAt(Date(System.currentTimeMillis() + jwtConfiguration.ttl))
            .sign(jwtConfiguration.algorithm)

        authenticated.add(oauthToken)
        return AuthResponse(jwtToken, user)
    }

    private fun fetchOAuth2(jwt: JWTCredential): String =
        jwt.payload.getClaim(OAUTH2_CLAIM).asString()

    fun invalidateToken(jwt: JWTCredential) =
        authenticated.remove(fetchOAuth2(jwt))

    fun isAuthenticated(jwt: JWTCredential): Boolean =
        authenticated.contains(fetchOAuth2(jwt))

    private suspend inline fun <reified T> requestGitHubApi(request: String, accessToken: String): T {
        return githubClient.get(request) {
            headers {
                header("Authorization", "token $accessToken")
                header("Accept",  "application/vnd.github.v3+json")
            }
        }
    }

}