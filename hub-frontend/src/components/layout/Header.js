import { Flex, Box, Heading, Link, Button, Text, Menu, MenuButton, MenuItem, MenuGroup, MenuList, MenuDivider, useColorModeValue } from '@chakra-ui/react'
import { Container, Content } from 'components/layout/Container'
import { FaGithub } from 'react-icons/fa'
import { MdArrowDropDown } from 'react-icons/md'

import ThemeSwitch from 'components/layout/ThemeSwitch'
import { useAuth } from 'components/AuthProvider'

const Header = ({ title }) => {
  const bgColor = useColorModeValue('gray.50', 'gray.900')
  const color = useColorModeValue('black', 'white')

  return (
    <Container
      zIndex="1"
      height={{ sm: '4.5rem', base: 'auto' }}
      bg={bgColor}
      color={color}
      shadow="sm"
      paddingX="37px"
    >
      <Content
        flexDirection={{ sm: 'row', base: 'column' }}
        justifyContent="space-between"
        alignItems="center"
      >
        <Box width={{ sm: '100px', base: 'auto' }} paddingY={{ sm: '0px', base: '7px' }}>
          <Link href="/" _focus={{ outline: 0 }}>
            <Heading fontSize="1.5rem" paddingRight="0px">
              Hub
            </Heading>
          </Link>
        </Box>
        <Nav paddingY={{ sm: '0px', base: '7px' }} />
        <Profile paddingY={{ sm: '0px', base: '7px' }} />
      </Content>
    </Container>
  )
}

const NavItem = (props) => {
  return (
    <Link href={props.href} fontWeight="bold" paddingX="13px" _focus={{ outline: 0 }} {...props}>
      {props.label}
    </Link>
  )
}

const Nav = (props) => {
  return (
    <Flex {...props}>
      <NavItem label="About" href="/about" />
      <NavItem label="Docs" href="/docs" />
      <NavItem label="Explore" href="/explore" />
      <NavItem label="Support" href="https://panda-lang.org/support/" />
    </Flex>
  )
}

const Profile = (props) => {
  const { token, user, logout } = useAuth()

  const authView = () => {
    if (token) {
      return (
        <Flex>
          <Menu>
            <MenuButton as={Button} rightIcon={<MdArrowDropDown />}>
              {user.username}
            </MenuButton>
            <MenuList>
              <MenuDivider />
              <Box paddingX="12px">
                Dark mode
                <ThemeSwitch marginX="7px" />
              </Box>
              <MenuDivider />
              <MenuGroup>
                <MenuItem>My profile</MenuItem>
                <MenuItem>Settings </MenuItem>
                <MenuItem onClick={logout}>Logout</MenuItem>
              </MenuGroup>
            </MenuList>
          </Menu>
        </Flex>
      )
    } else {
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
    <Flex alignItems="center" display={{ sm: 'flex', base: 'none' }} {...props}>
      {authView()}
    </Flex>
  )
}

export default Header
