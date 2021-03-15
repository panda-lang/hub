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

import { Box, Flex, Link, Text, useColorModeValue } from '@chakra-ui/react'
import { FaGithub, FaTwitter } from 'react-icons/fa'

import { Container, Content } from './Container'

const Footer = () => {
  const bgColor = useColorModeValue('gray.50', 'gray.900')
  const color = useColorModeValue('black', 'white')

  return (
    <Container bg={bgColor} color={color} height="2.5rem" padding="7px">
      <Content justifyContent="space-around">
        <Flex flexDirection="row" paddingY="6px">
          <Box marginX="7px">
            <FaTwitter />
          </Box>
          <Box marginX="7px">
            <FaGithub />
          </Box>
        </Flex>
        <Text
          fontSize="0.8rem"
          // fontStyle="italic"
          paddingTop="0.2rem"
        >
          ~ powered by&nbsp;
          <Link href="https://github.com/panda-lang/hub" color="blue.400">
            @panda-lang/hub
          </Link>
        </Text>
      </Content>
    </Container>
  )
}

export default Footer
