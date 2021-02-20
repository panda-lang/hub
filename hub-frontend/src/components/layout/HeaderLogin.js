import { Flex, Text, Box, Link } from '@chakra-ui/react'
import { FaGithub } from 'react-icons/fa'
import { IoExitOutline } from 'react-icons/io5'

import ColorModeSwitch from 'components/layout/ColorModeSwitch'
import { useAuth } from 'components/AuthProvider'

const HeaderLogin = props => {
  const { token, user, logout } = useAuth()

  const authView = () => {
    if (token) {
      return (
        <Flex width="100px" onClick={logout}>
          <Text>{user.username}</Text>
          <Text marginTop="4px" marginLeft="7px">
            <IoExitOutline fontSize="1.15rem" />
          </Text>
        </Flex>
      )
    }
    else {
      return (
        <Link href="http://localhost:8080/authorize/github">
          <Flex width="100px">
            <Text>Sign In</Text>
            <Text marginTop="4px" marginLeft="7px">
              <FaGithub fontSize="1.15rem" />
            </Text>
          </Flex>
        </Link>
      )
    }
  }

  return (
    <Flex
      alignItems="center"
      display={{ sm: "flex", base: "none" }}
      {...props}
    >
      { authView() }
      <ColorModeSwitch marginTop="0.3rem" />
    </Flex>
  )
}

export default HeaderLogin