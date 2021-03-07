import { useEffect, useState } from 'react'
import router from 'next/router'
import useClient from './useClient'
import { useAuth } from '../components/AuthProvider'

export default function useUser(
  {
    redirectTo = false,
    redirectIfFound = false,
  } = {}
) {
  const { token } = useAuth()
  const [user, setUser] = useState()

  useEffect(() => {
    useClient('/user', token)
      .then(response => setUser(response))
  }, [token])

  // const { data: user, mutate: mutateUser } = useClient('/user', token)
  return { user } 
  /*
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
  */
/*
  useEffect(() => {
    if (!redirectTo || !user) return

    if (
      // If redirectTo is set, redirect if the user was not found.
      (redirectTo && !redirectIfFound && !user?.isLoggedIn) ||
      // If redirectIfFound is also set, redirect if the user was found
      (redirectIfFound && user?.isLoggedIn)
    ) {
      router.push(redirectTo)
    }
  }, [user, redirectIfFound, redirectTo])
*/
  // return { user, mutateUser }
}
