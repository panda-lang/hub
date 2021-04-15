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

package org.panda_lang.hub.shared.paging

import kotlin.math.ceil

class Page<T>(
    val content: List<T>,
    val pageSize: Int,
    val pageNumber: Int,
    val pagesCount: Int
)

fun Number.toPages(pageSize: Int) =
    ceil(this.toDouble() / pageSize.toDouble()).toInt()

fun <T> List<T>.page(page: Int, pageSize: Int, total: Number): Page<T> = this
    .drop(page * pageSize)
    .take(pageSize)
    .let { Page(it, pageSize, page, total.toLong().toPages(pageSize)) }
