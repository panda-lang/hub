package org.panda_lang.hub.user

import org.litote.kmongo.eq
import org.litote.kmongo.coroutine.*

internal class UserRepository(database: CoroutineDatabase) {

    private val collection = database.getCollection<User>()

    suspend fun findUserById(id: String): User? {
        return collection.findOne(User::id eq id)
    }

    suspend fun saveUser(user: User): User {
        collection.insertOne(user)
        return user
    }

}