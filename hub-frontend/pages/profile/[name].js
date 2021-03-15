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

import Head from 'next/head'
import { Spinner, Box, Text, Flex, useColorModeValue, Img, Divider } from '@chakra-ui/react'

import Page from '../../components/layout/Page'
import Header from '../../components/layout/Header'
import Main from '../../components/layout/Main'
import Footer from '../../components/layout/Footer'

import { useState, useEffect } from 'react'
import { useRouter } from 'next/router'
import { useClient } from '../../lib/useClient'
import { useUser } from '../../lib/useUser'
import PackageModal from '../../components/package/PackageModal'

const Profile = () => {
  const router = useRouter()
  const { name } = router.query

  return (
    <Page>
      <Head>
        <title>Hub - Profile</title>
      </Head>
      <Header />
      <Main content={
        <Description name={name} />
      }>
      </Main>
      <Footer />
    </Page>
  )
}

const Description = (props) => {
  const bgColor = useColorModeValue('gray.50', 'gray.800')
  const bioBgColor = useColorModeValue('gray.100', 'gray.700')

  const [profile, setProfile] = useState()
  const name = props.name

  if (name && !profile) {
    useClient(`/profile/${name}`)
      .then((response) => setProfile({
        found: true,
        ...response.profile
      }))
      .catch((error) => setProfile({
        found: false,
        error: error.message
      }))
  }

  if (!profile) {
    return <Spinner />
  }

  if (!profile.found) {
    return <Text>User not found</Text>
  }

  return (
    <Flex
      flexDirection="column"
      maxWidth="1280px"
      width="90%"
      paddingX="27px"
      {...props}
    >
      <Head>
        <title>Hub - {profile.login}'s profile</title>
      </Head>
      <Flex bg={bgColor} padding="17px" shadow="sm" borderRadius="7px">
        <Img src={profile.avatar_url} boxSize="128px" border={`2px solid #1d1d1d`} borderRadius="17px" />
        <Flex flexDirection="column" paddingX="27px">
          <Flex height="52px">
            <Text fontSize="3xl" fontWeight="bold">{profile.name}</Text>
            <Text fontSize="2xl" fontStyle="italic" paddingX="21px" paddingTop="5px">{profile.login}</Text>
          </Flex>
          <Text whiteSpace="pre-line" bg={bioBgColor} padding="12px" borderRadius="7px">{profile.bio}</Text>
        </Flex>
      </Flex>
      <PackageModal login={profile.login}/>
    </Flex>
  )
}

export default Profile
