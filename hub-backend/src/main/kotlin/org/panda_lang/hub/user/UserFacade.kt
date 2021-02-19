package org.panda_lang.hub.user

import org.panda_lang.hub.github.GitHubUser

class UserFacade internal constructor(
    private val userRepository: UserRepository
) {

    suspend fun findUserById(id: String): User {
        return userRepository.findUserById(id)!!
    }

    suspend fun fetchUser(githubUser: GitHubUser): User {
        return userRepository.findUserById(githubUser.id) ?: run {
            val user = User(githubUser.id, githubUser.login, ArrayList())
            return userRepository.saveUser(user)
        }
    }

}