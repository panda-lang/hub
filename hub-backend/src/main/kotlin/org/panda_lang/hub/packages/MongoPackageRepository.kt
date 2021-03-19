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

package org.panda_lang.hub.packages

import org.litote.kmongo.coroutine.CoroutineCollection
import org.litote.kmongo.div
import org.litote.kmongo.eq
import org.panda_lang.hub.github.RepositoryId
import org.panda_lang.hub.user.Profile
import org.panda_lang.hub.user.User

internal class MongoPackageRepository(private val collection: CoroutineCollection<Package>) : PackageRepository {

    override suspend fun savePackage(pkg: Package): Package =
        pkg.also { collection.insertOne(it) }

    override suspend fun findPackageById(id: String): Package? =
        collection.findOne(Package::_id eq id)

    override suspend fun findPackageByRepositoryId(id: RepositoryId): Package? =
        collection.findOne(Package::fullName eq id.fullName())

    override suspend fun findPackagesByUser(login: String): Collection<Package> =
        collection.find(Package::owner / User::profile / Profile::login eq login).toList()

}
