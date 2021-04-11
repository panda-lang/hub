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

import org.litote.kmongo.mapProperty
import org.litote.kmongo.property.KPropertyPath
import kotlin.reflect.KProperty1

fun String.encodeMongo(): String = replace("\\", "\\\\").replace("\$", "\\u0024").replace(".", "\\u002e")

fun String.decodeMongo(): String = replace("\\u002e", ".").replace("\\u0024", "\$").replace("\\\\", "\\")

@Suppress("UNCHECKED_CAST")
fun <K, T> KProperty1<out Any?, Map<out K, T>?>.keyProjection(key: K): KPropertyPath<Any?, T?> =
    mapProperty.keyProjection(key) as KPropertyPath<Any?, T?>
