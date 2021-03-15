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

import {
  Box,
  Flex,
  Text,
  AvatarGroup,
  Avatar,
  useColorModeValue,
} from '@chakra-ui/react'
import { HiOutlineDotsHorizontal } from 'react-icons/hi'

const PackagePreview = (props) => {
  const bgColor = useColorModeValue('gray.50', 'gray.800')
  const color = useColorModeValue('black', 'white')
  const imgA = useColorModeValue(
    'https://bit.ly/sage-adebayo',
    'https://bit.ly/ryan-florence'
  )
  const imgB = useColorModeValue(
    'https://bit.ly/ryan-florence',
    'https://bit.ly/sage-adebayo'
  )

  return (
    <Flex
      minWidth="320px"
      width="30%"
      maxWidth="360px"
      height="130px"
      marginY="17px"
      bg={bgColor}
      shadow="sm"
      wrap="wrap"
      borderRadius="7px"
    >
      <Flex flexDirection="column" w="full">
        <Flex
          flexDirection="row"
          padding="17px"
          width="full"
          height="65px"
          position="relative"
        >
          <Box bg="lightgrey" width="48px" height="48px"></Box>
          <Flex flexDirection="column" fontSize="1rem" paddingX="17px">
            <Text fontWeight="bold">Name</Text>
            <Text color="grey.700">Description</Text>
          </Flex>
          <Box
            size="32px"
            position="absolute"
            top="17px"
            right="17px"
            cursor="pointer"
          >
            <HiOutlineDotsHorizontal fontSize="1.25rem" />
          </Box>
        </Flex>
      </Flex>
      <AvatarGroup size="sm" max={2} padding="17px">
        <Avatar name="Segun Adebayo" src={imgA} />
        <Avatar name="Ryan Florence" src={imgB} />
        <Avatar name="Kent Dodds" src="https://bit.ly/kent-c-dodds" />
        <Avatar name="Prosper Otemuyiwa" src="https://bit.ly/prosper-baba" />
        <Avatar name="Christian Nwamba" src="https://bit.ly/code-beast" />
      </AvatarGroup>
    </Flex>
  )
}

export { PackagePreview }
