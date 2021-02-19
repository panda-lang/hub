import { Box, Flex, Link, Text, useColorModeValue } from "@chakra-ui/react"
import { FaGithub, FaTwitter } from 'react-icons/fa'
import { Container, Content } from './Container'

const Footer = () => {
  const bgColor = useColorModeValue('gray.50', 'gray.900')
  const color = useColorModeValue('black', 'white')

  return (
    <Container
      bg={bgColor}
      color={color}
      height="2.5rem"
      padding="7px"
    >
      <Content justifyContent="space-around">
        <Flex flexDirection="row" paddingY="6px">
          <Box marginX="7px">
            <FaTwitter />
          </Box>
          <Box marginX="7px">
            <FaGithub />
          </Box>
        </Flex>
        <Text
          fontSize="0.8rem"
          // fontStyle="italic"
          paddingTop="0.2rem"
        >
          ~ powered by&nbsp;
          <Link href="https://github.com/panda-lang/hub" color="blue.400">
            @panda-lang/hub
          </Link>
        </Text>
      </Content>
    </Container>
  )
}

export default Footer