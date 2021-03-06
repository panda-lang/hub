import { Flex, Heading, Text } from '@chakra-ui/react'

const Hero = () => {
  return (
    <Flex
      flexDirection="column"
      alignItems="center"
      textAlign="center"
      justifyContent="center"
    >
      <Heading paddingBottom="17px">Where the Universe begins</Heading>
      <Text maxWidth="600px" paddingX="17px">
        Instantly publish packages and spread it around the world. Explore new
        possibilities and find out more information about latest discoveries{' '}
        <br /> in the panda-lang related ecosystem 💕
      </Text>
    </Flex>
  )
}

export default Hero
