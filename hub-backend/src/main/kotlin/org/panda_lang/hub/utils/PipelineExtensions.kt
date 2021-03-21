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

import io.ktor.application.ApplicationCall
import io.ktor.application.call
import io.ktor.auth.Principal
import io.ktor.auth.authentication
import io.ktor.http.HttpStatusCode
import io.ktor.response.respond
import io.ktor.util.pipeline.PipelineContext
import org.panda_lang.hub.failure.ErrorResponseException

 inline fun <reified P : Principal> PipelineContext<Unit, ApplicationCall>.principal(consumer: (principal: P) -> Unit) =
    call.authentication.principal<P>()?.let {
        consumer.invoke(it)
    }.orThrow {
        ErrorResponseException(HttpStatusCode.Unauthorized, "Missing JWT principal")
    }

suspend inline fun <reified R : Any> PipelineContext<Unit, ApplicationCall>.respondIf(condition: Boolean, supplier: () -> R?): R? =
    if (condition) respond(supplier) else null

suspend inline fun <reified R : Any> PipelineContext<Unit, ApplicationCall>.respond(supplier: () -> R?): R? =
    supplier.invoke()?.also { context.respond(it) }

fun Any?.orThrow(supplier: () -> Exception): Any =
    this ?: throw supplier.invoke()
