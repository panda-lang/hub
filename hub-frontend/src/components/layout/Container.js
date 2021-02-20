import { Flex } from '@chakra-ui/react'

const Container = props => {
  return (
    <Flex width='full' justifyContent='center' {...props}>
      {props.children}
    </Flex>
  )
}

const Content = props => {
  return (
    <Flex w='full' maxWidth='1280px' {...props}>
      {props.children}
    </Flex>
  )
}

export { Container, Content }