import { useEffect } from 'react'
import { useRouter } from 'next/router'
import { Link } from '@chakra-ui/react'

import { useAuth } from 'components/AuthProvider'

// TODO: It's kinda slow, probably bcs of the dev mode?

const Authorized = () => {
  const { login } = useAuth()
  const router = useRouter()
  const token = router.query.token

  useEffect(() => {
    if (token) {
      login(token)
    }
    
    router.replace('/')
  })

  return <Link href="/">Authenticating...</Link>
}

export default Authorized