/*
 * Copyright (c) 2018-2019 Reposilite Team
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

package org.panda_lang.reposilite.utils.helper;

import org.springframework.util.SerializationUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Base64;
import java.util.Optional;

public final class CookieHelper {

  private CookieHelper() {}

  public static void removeCookie(String cookieName, HttpServletRequest servletRequest, HttpServletResponse servletResponse) {
    obtainCookie(cookieName, servletRequest.getCookies()).ifPresent(cookie -> appendCookie(cookieName, "", 0, servletResponse));
  }

  public static void appendCookie(String cookieName, String cookieValue, int maxAge, HttpServletResponse servletResponse) {
    Cookie cookie = new Cookie(cookieName, cookieValue);
    cookie.setPath("/");

    cookie.setHttpOnly(true);
    cookie.setMaxAge(maxAge);

    servletResponse.addCookie(cookie);
  }

  public static Optional<Cookie> obtainCookie(String cookieName, Cookie[] cookies) {
    if (cookies != null && cookies.length > 0) {
      for (Cookie cookie : cookies) {
        if (cookieName.equals(cookie.getName())) {
          return Optional.of(cookie);
        }
      }
    }

    return Optional.empty();
  }

  public static String serialize(Object object) {
    return Base64.getUrlEncoder().encodeToString(SerializationUtils.serialize(object));
  }

  public static <T> T deserialize(Cookie cookie, Class<T> clazz) {
    return clazz.cast(SerializationUtils.deserialize(Base64.getUrlDecoder().decode(cookie.getValue())));
  }

}
