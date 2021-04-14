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

package org.panda_lang.hub.utils

import org.litote.kmongo.colProperty
import org.litote.kmongo.coroutine.CoroutineCollection
import org.litote.kmongo.coroutine.CoroutineFindPublisher
import org.litote.kmongo.property.KPropertyPath
import org.panda_lang.hub.shared.paging.Page
import kotlin.math.ceil
import kotlin.reflect.KProperty1

fun String.encodeMongo() = replace("\\", "\\\\")
    .replace("\$", "\\u0024")
    .replace(".", "\\u002e")

fun String.decodeMongo() = replace("\\u002e", ".")
    .replace("\\u0024", "\$")
    .replace("\\\\", "\\")

@Suppress("UNCHECKED_CAST")
val <T> KProperty1<out Any?, Iterable<T>?>.posOp: KPropertyPath<Any?, T?>
    get() = colProperty.posOp as KPropertyPath<Any?, T?>

@Suppress("UNCHECKED_CAST")
fun <T> KProperty1<out Any?, Iterable<T>?>.filteredPosOp(identifier: String): KPropertyPath<Any?, T?> =
    colProperty.filteredPosOp(identifier) as KPropertyPath<Any?, T?>

suspend fun <T : Any> CoroutineFindPublisher<T>.page(collection: CoroutineCollection<T>, page: Int, pageSize: Int): Page<T> = this
    .skip(page * pageSize)
    .limit(pageSize)
    .toList()
    .let {
        Page(it, pageSize, page, ceil(collection.countDocuments() / (pageSize.toDouble())).toInt())
    }
