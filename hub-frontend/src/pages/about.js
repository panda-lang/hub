import Head from 'next/head'
import { Box } from '@chakra-ui/react'

import Page from 'components/layout/Page'
import Header from 'components/layout/Header'
import Main from 'components/layout/Main'
import Footer from 'components/layout/Footer'

const About = () => {
  return (
    <Page>
      <Head>
        <title>Hub - About</title>
      </Head>
      <Header />
      <Main content={<Box></Box>} />
      <Footer />
    </Page>
  )
}

export default About
