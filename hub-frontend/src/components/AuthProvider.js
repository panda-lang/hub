import { useState, createContext, useContext, useEffect } from 'react'
import Cookies from 'universal-cookie'
import axios from 'axios'

const AuthContext = createContext()
const cookies = new Cookies()

const AuthProvider = ({ children }) => {
  const [token, setToken] = useState()
  const [user, setUser] = useState()

  useEffect(() => {
    setToken(cookies.get('jwt'))

    if (token) {
      fetchUser()
    }
  }, [token])

  const handleLogin = (jwt) => {
    cookies.set('jwt', jwt, {
      path: '/',
      maxAge: 60 * 60 * 24 * 30, // 30 days
      sameSite: true,
    })
    setToken(jwt)
  }

  const handleLogout = () => {
    cookies.remove('jwt')
    setUser(undefined)
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

  const fetchUser = () => {
    handleRequest('/user')
      .then((response) => {
        setUser(response.data)
      })
      .catch((error) => {
        console.log(error)
        if (error?.data?.status >= 400) {
          handleLogout()
        }
      })
  }

  const context = {
    token,
    user,
    handleLogin,
    handleLogout,
    handleRequest,
  }

  return <AuthContext.Provider value={context}>{children}</AuthContext.Provider>
}

const useAuth = () => useContext(AuthContext)

export { AuthProvider, useAuth }
