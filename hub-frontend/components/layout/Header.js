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
import Link from 'next/link'
import {
  Flex,
  Box,
  Heading,
  Link as ChakraLink,
  Button,
  Img,
  Text,
  Menu,
  MenuButton,
  MenuItem,
  MenuGroup,
  MenuList,
  MenuDivider,
  useColorModeValue,
  useToast,
  Spinner,
  useDisclosure,
} from '@chakra-ui/react'
import { Container, Content } from './Container'
import { FaGithub } from 'react-icons/fa'
import { MdArrowDropDown } from 'react-icons/md'
import ThemeSwitch from './ThemeSwitch'

import { useAuth } from '../AuthProvider'
import { useUser } from '../../lib/useUser'
import { getEndpoint } from '../../lib/useClient'
import PackageModal from '../package/PackageModal'

const Header = (props) => {
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
      {...props}
    >
      <Content
        flexDirection={{ sm: 'row', base: 'column' }}
        justifyContent="space-between"
        alignItems="center"
      >
        <Box
          width={{ sm: '100px', base: 'auto' }}
          paddingY={{ sm: '0px', base: '7px' }}
        >
          <ChakraLink href="/" _focus={{ outline: 0 }}>
            <Heading fontSize="1.5rem" paddingRight="0px">
              Hub
            </Heading>
          </ChakraLink>
        </Box>
        <Navigation paddingY={{ sm: '0px', base: '7px' }} />
        <Profile paddingY={{ sm: '0px', base: '7px' }} />
      </Content>
    </Container>
  )
}

const Navigation = (props) => {
  return (
    <Flex {...props}>
      <NavigationItem label="About" href="/about" />
      <NavigationItem label="Docs" href="/docs" />
      <NavigationItem label="Explore" href="/explore" />
      <NavigationItem label="Support" href="https://panda-lang.org/support/" />
    </Flex>
  )
}

const NavigationItem = (props) => {
  return (
    <ChakraLink
      href={props.href}
      fontWeight="bold"
      paddingX="13px"
      _focus={{ outline: 0 }}
      {...props}
    >
      {props.label}
    </ChakraLink>
  )
}

const Profile = (props) => {
  const { token } = useAuth()

  return (
    <Flex alignItems="center" display={{ sm: 'flex', base: 'none' }} {...props}>
      {token ? <ProfileMenu /> : <Login />}
    </Flex>
  )
}

const Login = (props) => {
  return (
    <ChakraLink href={getEndpoint('/authorize/github')} {...props}>
      <Flex width="100px">
        <Text>Sign In</Text>
        <Text marginTop="4px" marginLeft="7px">
          <FaGithub fontSize="1.15rem" />
        </Text>
      </Flex>
    </ChakraLink>
  )
}

const ProfileMenu = (props) => {
  const { isOpen, onOpen, onClose } = useDisclosure()
  const { handleLogout } = useAuth()
  const toast = useToast()

  const { user } = useUser({ redirectTo: '/' }, (user) => {
    if (!user.authorized) {
      handleLogout()
      toast({
        title: 'Invalid session',
        status: 'error',
        duration: 6000,
        position: 'top',
      })
    }
  })

  const openPackageModal = () => {
    setPackageModal(!packageModal)
  }

  if (!user?.authorized) {
    return <Spinner />
  }

  const profile = user.profile

  return (
    <Flex>
      <Menu>
        <MenuButton as={Button} rightIcon={<MdArrowDropDown />}>
          <Flex flexDirection="row" justifyContent="center" alignItems="center">
            <Img src={profile.avatar_url} boxSize="23px" borderRadius="full" />
            <Box marginLeft="10px">{profile.login}</Box>
          </Flex>
        </MenuButton>
        <MenuList border="0">
          <MenuGroup>
            <Link href={'/profile/' + profile.login}>
              <MenuItem as={ChakraLink}>My profile</MenuItem>
            </Link>
            <MenuItem onClick={onOpen}>Add package</MenuItem>
            <MenuItem>Settings </MenuItem>
            <MenuItem onClick={handleLogout}>Logout</MenuItem>
          </MenuGroup>
          <MenuDivider />
          <Box paddingX="12px">
            Dark mode
            <ThemeSwitch marginX="7px" />
          </Box>
          <MenuDivider />
        </MenuList>
      </Menu>
      <PackageModal isOpen={isOpen} onClose={onClose} login={profile.login} />
    </Flex>
  )
}

export default Header
