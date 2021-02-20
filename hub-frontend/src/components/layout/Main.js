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
