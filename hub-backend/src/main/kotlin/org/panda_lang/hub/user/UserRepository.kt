package org.panda_lang.hub.user

internal interface UserRepository {

    suspend fun findUserById(id: Long): User?

    suspend fun findUserByLogin(login: String): User?

    suspend fun saveUser(user: User): User

}
