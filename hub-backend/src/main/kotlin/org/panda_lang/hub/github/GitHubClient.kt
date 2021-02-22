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

package org.panda_lang.hub.github

import io.ktor.client.*
import io.ktor.client.features.json.*
import io.ktor.client.request.*
import io.ktor.http.*

class GitHubClient {

    val githubClient = HttpClient {
        install(JsonFeature) {
            accept(ContentType.Application.Json)
        }
    }

    @PublishedApi
    internal suspend inline fun <reified T> request(request: String, accessToken: String): T {
        return this.githubClient.get(request) {
            headers {
                header("Authorization", "token $accessToken")
                header("Accept",  "application/vnd.github.v3+json")
            }
        }
    }

}