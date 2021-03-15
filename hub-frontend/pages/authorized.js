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

import { useEffect } from 'react'
import { useRouter } from 'next/router'
import { Flex, Link, Spinner } from '@chakra-ui/react'

import { useAuth } from '../components/AuthProvider'

const Authorized = () => {
  const { handleLogin } = useAuth()
  const router = useRouter()

  useEffect(() => {
    const jwt = router.query.token

    if (jwt) {
      handleLogin(jwt)
      router.replace('/')
    }
  }, [router])

  return (
    <Flex justifyContent="center" alignItems="center" height="100vh">
      <Link href="/">
        <Spinner />
      </Link>
    </Flex>
  )
}

export default Authorized
