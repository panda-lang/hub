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

import { useState, createContext, useContext, useEffect } from 'react'
import Cookies from 'universal-cookie'
import axios from 'axios'

const JWT_COOKIE = 'jwt'

const AuthContext = createContext()
const cookies = new Cookies()

const AuthProvider = ({ children }) => {
  const [token, setToken] = useState()

  useEffect(() => {
    setToken(cookies.get(JWT_COOKIE))
  }, [])

  cookies.addChangeListener((event) => {
    if (event.name === JWT_COOKIE) {
      setToken(event.value)
    }
  })

  const handleLogin = (jwt) => {
    cookies.set(JWT_COOKIE, jwt, {
      path: '/',
      maxAge: 60 * 60 * 24 * 30, // 30 days
      sameSite: true,
    })
  }

  const handleLogout = () => {
    cookies.remove(JWT_COOKIE)
  }

  const handleRequest = (route, options) => {
    return axios.get(`http://localhost:8080${route}`, {
      headers: {
        Authorization: `Bearer ${token}`,
      },
      ...options,
    })
  }

  const context = {
    token,
    handleLogin,
    handleLogout,
    handleRequest,
  }

  return <AuthContext.Provider value={context}>{children}</AuthContext.Provider>
}

const useAuth = () => useContext(AuthContext)

export { AuthProvider, useAuth }
