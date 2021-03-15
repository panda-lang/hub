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

import Head from 'next/head'
import { Flex } from '@chakra-ui/react'

import Page from '../components/layout/Page'
import Header from '../components/layout/Header'
import Main from '../components/layout/Main'
import Footer from '../components/layout/Footer'
import Hero from '../components/index/Hero'
import PackagesHero from '../components/index/PackagesHero'

const Index = () => {
  return (
    <Page>
      <Head>
        <title>Hub - Index</title>
      </Head>
      <Header />
      <Main
        content={
          <Flex flexDirection="column" alignItems="center" paddingY="77px">
            <Hero />
            <PackagesHero marginY="77px" />
          </Flex>
        }
      />
      <Footer />
    </Page>
  )
}

export default Index
