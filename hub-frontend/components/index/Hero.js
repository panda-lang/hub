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

import { Flex, Heading, Text } from '@chakra-ui/react'

const Hero = () => {
  return (
    <Flex
      flexDirection="column"
      alignItems="center"
      textAlign="center"
      justifyContent="center"
    >
      <Heading paddingBottom="17px">Where the Universe begins</Heading>
      <Text maxWidth="600px" paddingX="17px">
        Instantly publish packages and spread it around the world. Explore new
        possibilities and find out more information about latest discoveries{' '}
        <br /> in the panda-lang related ecosystem 💕
      </Text>
    </Flex>
  )
}

export default Hero
