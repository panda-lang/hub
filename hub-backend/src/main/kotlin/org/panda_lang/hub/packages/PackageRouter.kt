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

import io.ktor.locations.Location
import io.ktor.locations.get
import io.ktor.locations.post
import io.ktor.routing.Routing

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

internal fun Routing.routes(packageEndpoint: PackageEndpoint) {
    get <RepositoriesLocation> { repositoriesLocation ->
        packageEndpoint.repositories(this.context, repositoriesLocation.login)
    }
    get <PackagesLocation> { packagesLocation ->
        packageEndpoint.packages(this.context, packagesLocation.login)
    }
    get <PackageLocation> { packageLocation ->
        packageEndpoint.`package`(this.context, packageLocation.login, packageLocation.name)
    }
    post <PackageLocation> { packageLocation ->
        packageEndpoint.fetchPackage(this.context, packageLocation.login, packageLocation.name)
    }
}
