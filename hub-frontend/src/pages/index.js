import Head from 'next/head'
import { Flex } from '@chakra-ui/react'

import Page from 'components/layout/Page'
import Header from 'components/layout/Header'
import Main from 'components/layout/Main'
import Footer from 'components/layout/Footer'
import Hero from 'components/index/Hero'
import PackagesHero from 'components/index/PackagesHero'

const Index = () => {
  return (
    <Page>
      <Head>
        <title>Hub - Index</title>
      </Head>
      <Header />
      <Main content={
        <Flex
          flexDirection='column'
          alignItems='center'
          paddingY='77px'
        >
          <Hero />
          <PackagesHero marginY='77px' />
        </Flex>
      } />
      <Footer />
    </Page>
  )
}

export default Index