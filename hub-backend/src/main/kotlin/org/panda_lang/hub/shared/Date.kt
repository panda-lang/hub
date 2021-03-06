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

package org.panda_lang.hub.shared

import kotlinx.serialization.Serializable
import java.time.LocalDate

typealias DateId = String

@Serializable
data class Date(
    val year: Int,
    val month: Int,
    val day: Int
) {

    companion object {
        fun now() = LocalDate.now().toDate()
        fun yesterday() = LocalDate.now().minusDays(1).toDate()
    }

    override fun toString(): DateId = "$year-${month.asDateUnit()}-${day.asDateUnit()}"

}

fun LocalDate.toDate() = Date(year, monthValue, dayOfMonth)

private fun Int.asDateUnit() = this.toString().padStart(2, '0')
