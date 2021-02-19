import axios from 'axios'
import { ChakraProvider, ColorModeProvider } from '@chakra-ui/react'

import { AuthProvider } from '../components/AuthProvider'
import 'focus-visible/dist/focus-visible'
import theme from '../theme'

function HubApp ({ Component, pageProps }) {
  return (
    <ChakraProvider resetCSS theme={theme}>
      <ColorModeProvider
        options={{
          useSystemColorMode: false
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
