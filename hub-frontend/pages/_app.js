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

import 'focus-visible/dist/focus-visible'

import { ChakraProvider, ColorModeProvider } from '@chakra-ui/react'

import { AuthProvider } from '../components/AuthProvider'
import theme from '../theme'

// eslint-disable-next-line react/prop-types
function HubApp({ Component, pageProps }) {
  return (
    <ChakraProvider resetCSS theme={theme}>
      <ColorModeProvider
        options={{
          useSystemColorMode: false,
        }}
      >
        <AuthProvider>
          <Component {...pageProps} />
        </AuthProvider>
      </ColorModeProvider>
    </ChakraProvider>
  )
}

export default HubApp
