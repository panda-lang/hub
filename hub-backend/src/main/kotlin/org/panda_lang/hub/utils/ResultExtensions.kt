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

import com.github.michaelbull.result.Err
import com.github.michaelbull.result.Ok
import com.github.michaelbull.result.Result
import com.github.michaelbull.result.mapBoth
import io.ktor.application.ApplicationCall
import io.ktor.response.respond

fun <T> T.asOk(): Ok<T> = Ok(this)

fun <T> T.asErr(): Err<T> = Err(this)

suspend inline fun <reified V : Any, reified E : Any> Result<V, E>.respond(ctx: ApplicationCall) =
    this.mapBoth(
        { response -> ctx.respond(response) },
        { error -> ctx.respond(error) }
    )
