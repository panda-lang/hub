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

import { Flex, useColorModeValue } from '@chakra-ui/react'

const Main = (props) => {
  const bgColor = useColorModeValue('gray.100', 'gray.900')
  const color = useColorModeValue('black', 'white')

  return (
    <Flex
      flexDirection="column"
      alignItems="center"
      justifyContent="center"
      width="full"
      minHeight="calc(100vh - 7rem)"
      bg={bgColor}
      color={color}
    >
      {props.content}
    </Flex>
  )
}

export default Main
