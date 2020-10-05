/*
 * Copyright (c) 2020 Hub Team of panda-lang organization
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
package org.panda_lang.hub.authentication

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.PropertySource
import org.springframework.stereotype.Component

@Component
@ConfigurationProperties(prefix = "auth")
@PropertySource("classpath:auth.properties")
internal class AuthenticationProperties {
    val oauth = OAuth()
    val token = Token()

    data class OAuth(
        var redirectUrls: List<String?> = ArrayList()
    )

    data class Token(
        var secret: String? = null,
        var expiration: Long = 0
    )
}
