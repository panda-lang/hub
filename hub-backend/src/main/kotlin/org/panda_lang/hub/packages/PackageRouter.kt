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

import io.ktor.auth.authenticate
import io.ktor.auth.jwt.JWTPrincipal
import io.ktor.http.HttpStatusCode
import io.ktor.locations.Location
import io.ktor.locations.delete
import io.ktor.locations.get
import io.ktor.locations.post
import io.ktor.routing.Routing
import org.panda_lang.hub.auth.jwt.getLoginClaim
import org.panda_lang.hub.failure.ErrorResponseException
import org.panda_lang.hub.utils.ip
import org.panda_lang.hub.utils.orThrow
import org.panda_lang.hub.utils.principal
import org.panda_lang.hub.utils.respond
import org.panda_lang.hub.utils.respondIf

@Location("/repositories/{login}")
internal class RepositoriesLocation(val login: String)

@Location("/packages/{login}")
internal class PackagesLocation(val login: String)

@Location("/package/{login}/{name}")
internal class PackageLocation(val login: String, val name: String)

@Location("/package/{login}/{name}/versions")
internal class VersionsLocation(val login: String, val name: String)

@Location("/package/{login}/{name}/latest")
internal class LatestLocation(val login: String, val name: String)

internal fun Routing.routes(packageFacade: PackageFacade) {
    get <RepositoriesLocation> { repositoriesLocation ->
        respond {
            packageFacade.getAllPackages(repositoriesLocation.login)
        }
    }
    get <PackagesLocation> { packagesLocation ->
        respond {
            packageFacade.getPackages(packagesLocation.login)
        }
    }
    get <PackageLocation> { packageLocation ->
        respond {
            packageFacade.getPackage(packageLocation.login, packageLocation.name)?.also {
                packageFacade.incrementRequestsCount(it._id, context.ip())
            }
        }.orThrow {
            ErrorResponseException(HttpStatusCode.NotFound)
        }
    }

    authenticate("jwt") {
        post<PackageLocation> { packageLocation ->
            principal <JWTPrincipal> {
                respondIf(packageLocation.login == it.getLoginClaim()) {
                    packageFacade.getOrFetchPackage(packageLocation.login, packageLocation.name)
                }.orThrow {
                    ErrorResponseException(HttpStatusCode.Unauthorized)
                }
            }
        }
        delete<PackageLocation> { packageLocation ->
            respond {
                packageFacade.deletePackage(packageLocation.login, packageLocation.name).let {
                    if (it) HttpStatusCode.OK else HttpStatusCode.BadRequest
                }
            }
        }
    }
}
