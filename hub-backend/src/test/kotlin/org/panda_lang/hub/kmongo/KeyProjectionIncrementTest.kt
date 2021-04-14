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

package org.panda_lang.hub.kmongo

import kotlinx.coroutines.runBlocking
import kotlinx.serialization.Serializable
import org.litote.kmongo.coroutine.coroutine
import org.litote.kmongo.div
import org.litote.kmongo.inc
import org.litote.kmongo.keyProjection
import org.litote.kmongo.reactivestreams.KMongo
import org.litote.kmongo.upsert

fun main(): Unit = runBlocking {
    val mongoClient = KMongo.createClient("mongodb://localhost:27017").coroutine
    val database = mongoClient.getDatabase("keyprojectionstest")
    val entities = database.getCollection<IncEntity>()

    entities.updateOneById(
        "1",
        inc(IncEntity::values.keyProjection("key1") / Values::map.keyProjection("key2"), 1),
        upsert()
    )
}

@Serializable
private data class IncEntity(
    val _id: String,
    val values: Map<String, Values> = emptyMap()
)

@Serializable
private data class Values(
    val map: Map<String, Int> = emptyMap()
)
