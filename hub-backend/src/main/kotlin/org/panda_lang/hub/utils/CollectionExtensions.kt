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

import java.util.Queue

fun <T> Queue<T>.pollWhile(predicate: (Queue<T>) -> Boolean): List<T> =
    ArrayList<T>(this.size).also {
        while (predicate.invoke(this)) {
            it.add(this.poll())
        }
    }

fun <T> Iterable<T>.mapOnly(predicate: (T) -> Boolean, function: (T) -> T) = this
    .map {
        if (predicate.invoke(it)) function.invoke(it) else it
    }
    .toList()
