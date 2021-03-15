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
  }, [token, redirectIfFound, redirectTo])

  useEffect(() => {
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
      router.push(redirectTo)
    }
  }, [user])

  return { user }
}

export { useUser }
