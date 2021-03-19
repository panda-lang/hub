/*
 * Copyright (c) 2021 Hub Team of panda-lang organization
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.panda_lang.hub.user

class UserFacade internal constructor(private val userService: UserService) {

    suspend fun requestAuthenticatedUser(token: String): User = userService.requestAuthenticatedUser(token)

    suspend fun getRemoteUser(login: String): User = userService.getRemoteUser(login)

    suspend fun getUserByLogin(login: String): User? = userService.getUserByLogin(login)

    suspend fun getUser(id: String): User? = userService.getUser(id)

}
