package org.panda_lang.hub.user

import com.github.michaelbull.result.Result
import com.github.michaelbull.result.map
import org.panda_lang.hub.failure.ErrorResponse
import org.panda_lang.hub.github.GitHubClient
import org.panda_lang.hub.github.GitHubProfile

class UserFacade internal constructor(
    private val gitHubClient: GitHubClient,
    private val userRepository: UserRepository
) {

    suspend fun fetchUser(token: String): Result<User, ErrorResponse> {
        return gitHubClient.getProfile(token).map { fetchUser(it) }
    }

    private suspend fun fetchUser(profile: GitHubProfile): User {
        return userRepository.findUserById(profile.id) ?: run {
            val user = User(profile.id, profile.login)
            return@run userRepository.saveUser(user)
        }
    }

    suspend fun getUser(id: String): User? {
        return userRepository.findUserById(id)
    }

}