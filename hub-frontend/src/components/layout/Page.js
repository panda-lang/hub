import { Flex, useColorModeValue } from '@chakra-ui/react'

const Page = props => {
  const bgColor = useColorModeValue('gray.50', 'gray.900')
  const color = useColorModeValue('black', 'white')

  return (
    <Flex
      bg={bgColor}
      color={color}
      flexDirection='column'
      minH='100vh'
      {...props}
    />
  )
}

export default Page