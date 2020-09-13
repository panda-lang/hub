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
package org.panda_lang.hub.utils.helper

import org.springframework.util.SerializationUtils
import java.util.*
import javax.servlet.http.Cookie
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

object CookieHelper {

    fun removeCookie(cookieName: String, servletRequest: HttpServletRequest, servletResponse: HttpServletResponse) {
        obtainCookie(cookieName, servletRequest.cookies).ifPresent { cookie: Cookie? -> appendCookie(cookieName, "", 0, servletResponse) }
    }

    fun appendCookie(cookieName: String?, cookieValue: String?, maxAge: Int, servletResponse: HttpServletResponse) {
        val cookie = Cookie(cookieName, cookieValue)
        cookie.path = "/"
        cookie.isHttpOnly = true
        cookie.maxAge = maxAge
        servletResponse.addCookie(cookie)
    }

    fun obtainCookie(cookieName: String, cookies: Array<Cookie>?): Optional<Cookie> {
        if (cookies != null && cookies.isNotEmpty()) {
            for (cookie in cookies) {
                if (cookieName == cookie.name) {
                    return Optional.of(cookie)
                }
            }
        }

        return Optional.empty()
    }

    fun serialize(value: Any?): String {
        return Base64.getUrlEncoder().encodeToString(SerializationUtils.serialize(value))
    }

    fun <T> deserialize(cookie: Cookie?, clazz: Class<T>): T {
        return clazz.cast(SerializationUtils.deserialize(Base64.getUrlDecoder().decode(cookie!!.value)))
    }

}