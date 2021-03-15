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

import com.github.michaelbull.result.mapBoth
import io.ktor.application.ApplicationCall
import io.ktor.http.HttpStatusCode
import io.ktor.response.respond
import org.panda_lang.hub.failure.ErrorResponse

class PackageEndpoint(
    private val packageFacade: PackageFacade
) {

    suspend fun `package`(ctx: ApplicationCall, owner: String, name: String) {
        packageFacade.getPackage(owner, name)
            ?.let { ctx.respond(it) }
            ?: ctx.respond(ErrorResponse(HttpStatusCode.NotFound, "Not found"))
    }

    suspend fun packages(ctx: ApplicationCall, owner: String) {
        packageFacade.getP
    }

    suspend fun repositories(ctx: ApplicationCall, owner: String) {
        packageFacade.getRepositories(owner).mapBoth(
            { response -> ctx.respond(response) },
            { error -> ctx.respond(error) }
        )
    }

}
