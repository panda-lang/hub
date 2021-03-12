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
