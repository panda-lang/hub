import { useEffect } from 'react'
import { useRouter } from 'next/router'
import { Link } from '@chakra-ui/react'

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

  return <Link href="/">Authenticating...</Link>
}

export default Authorized
