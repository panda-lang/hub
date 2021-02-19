import { useState, createContext, useContext, useEffect } from 'react'
import axios from 'axios'

const AuthContext = createContext()
const userInfoUrl = 'http://localhost:8080/user'

// TODO: Such a mess 😭

const AuthProvider = ({ children }) => {
  const [token, setToken] = useState()
  const [user, setUser] = useState({})
  
  useEffect(() => {
    const storedToken = localStorage.getItem('token')

    if (storedToken != undefined) {
      setToken(storedToken)
    }
  }, [])

  useEffect(() => {
    if (token != undefined) {
      localStorage.setItem('token', token)

      axios
        .get('http://localhost:8080/user', {
          headers: {
            Authorization: `Bearer ${token}`
          }
        })
        .then(response => {
          setUser(response.data)
        })
        .catch(error => {
          console.log(error)
          logout()
        })
    }
    else {
      localStorage.removeItem('token')
    }
  }, [token])

  const login = value => {
    setToken(value)
  }

  const logout = () => {
    setToken(undefined)
  }

  const context = {
    token,
    user,
    login,
    logout
  }

  return (
    <AuthContext.Provider value={context}>
      {children}
    </AuthContext.Provider>
  )
}

const useAuth = () => useContext(AuthContext)

export {
  AuthProvider,
  useAuth
}