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
  }, [token])

  const handleLogin = (jwt) => {
    cookies.set(JWT_COOKIE, jwt, {
      path: '/',
      maxAge: 60 * 60 * 24 * 30, // 30 days
      sameSite: true,
    })
    setToken(jwt)
  }

  const handleLogout = () => {
    cookies.remove(JWT_COOKIE)
    setToken(undefined)
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
