import { useEffect } from 'react'
import { useRouter } from 'next/router'
import { Box, Link } from '@chakra-ui/react'
import { useAuth } from '../components/AuthProvider'

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