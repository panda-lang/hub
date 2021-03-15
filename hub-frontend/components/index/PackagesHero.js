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

import { Box, Flex, Heading, Input } from '@chakra-ui/react'
import { PackagePreview } from './PackagePreview'

const Category = (props) => {
  return (
    <Box
      paddingX="12px"
      paddingY="5px"
      cursor="pointer"
      fontWeight="bold"
      fontSize="0.9rem"
      height="2rem"
      borderRadius="none"
      {...props}
    >
      {props.children}
    </Box>
  )
}

const PackagesHero = (props) => {
  return (
    <Box maxWidth="1280px" w="80vw" paddingX="17px" {...props}>
      <Heading fontSize="1.25rem" paddingY="27px">
        Packages
      </Heading>
      <Flex
        justifyContent="space-between"
        flexDirection={{ md: 'row', base: 'column' }}
      >
        <Flex flexDirection="row">
          <Category bg="blue.400" color="white">
            Popular
          </Category>
          <Category>Trending</Category>
          <Category>Latest</Category>
        </Flex>
        <Flex flexDirection="row" paddingTop={{ md: '0px', base: '17px' }}>
          <Input size="sm" placeholder="Search package" marginRight="7px" />
          <Category minWidth="8.5rem" border="1px">
            + Add package
          </Category>
        </Flex>
      </Flex>
      <Flex
        justifyContent="space-around"
        wrap="wrap"
        marginY="21px"
        marginX="-2%"
        flexGrow="1"
      >
        <PackagePreview />
        <PackagePreview />
        <PackagePreview />
        <PackagePreview />
        <PackagePreview />
        <PackagePreview />
        <PackagePreview />
        <PackagePreview />
        <PackagePreview />
      </Flex>
    </Box>
  )
}

export default PackagesHero
