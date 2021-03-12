import { useEffect, useState } from 'react'
import router from 'next/router'
import { useClient } from './useClient'
import { useAuth } from '../components/AuthProvider'

const useUser = function (
  { redirectTo = false, redirectIfFound = false } = {},
  listener = () => {}
) {
  const { token } = useAuth()
  const [user, setUser] = useState()

  useEffect(() => {
    useClient('/user', token)
      .then((response) =>
        setUser({
          authorized: true,
          ...response,
        })
      )
      .catch((error) =>
        setUser({
          authorized: false,
          error,
        })
      )
      .finally(() => {
        if (user === undefined) {
          return
        }

        listener(user)

        if (!redirectTo) {
          return
        }

        if (
          // If redirectTo is set, redirect if the user was not found.
          (redirectTo && !redirectIfFound && !user?.authorized) ||
          // If redirectIfFound is also set, redirect if the user was found
          (redirectIfFound && user?.authorized)
        ) {
          console.log(user)
          router.push(redirectTo)
        }
      })
  }, [token, redirectIfFound, redirectTo])

  return { user }
}

export { useUser }
