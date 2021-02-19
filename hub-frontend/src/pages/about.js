import Head from 'next/head'

import Page from '../components/Page'
import Header from '../components/Header'
import Main from '../components/Main'
import Footer from '../components/Footer'
import { Box } from '@chakra-ui/react'

const About = () => {
  return (
    <Page>
      <Head>
        <title>Hub - About</title>
      </Head>
      <Header />
      <Main content={
        <Box>
          
        </Box>
      } />
      <Footer />
    </Page>
  )
}

export default About