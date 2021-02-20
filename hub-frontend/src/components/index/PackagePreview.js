import { Box, Flex, Text, AvatarGroup, Avatar, useColorModeValue } from '@chakra-ui/react'
import { HiOutlineDotsHorizontal } from 'react-icons/hi'

const PackagePreview = props => {
  const bgColor = useColorModeValue('gray.50', 'gray.800')
  const color = useColorModeValue('black', 'white')
  const imgA = useColorModeValue('https://bit.ly/sage-adebayo', 'https://bit.ly/ryan-florence')
  const imgB = useColorModeValue('https://bit.ly/ryan-florence', 'https://bit.ly/sage-adebayo')

  return (
    <Flex
      minWidth='320px'
      width='30%'
      maxWidth='360px'
      height='130px'
      marginY='17px'
      bg={bgColor}
      shadow='sm'
      wrap='wrap'
    >
      <Flex flexDirection='column' w='full'>
        <Flex
          flexDirection='row'
          padding='17px'
          width='full'
          height='65px'
          position='relative'
        >
          <Box bg='lightgrey' width='48px' height='48px'>
          </Box>
          <Flex flexDirection='column' fontSize='1rem' paddingX='17px'>
            <Text fontWeight='bold'>Name</Text>
            <Text color='grey.700'>Description</Text>
          </Flex>
          <Box size='32px' position='absolute' top='17px' right='17px' cursor='pointer'>
            <HiOutlineDotsHorizontal fontSize='1.25rem' />
          </Box>
        </Flex>
      </Flex>
      <AvatarGroup size='sm' max={2} padding='17px'>
        <Avatar name='Segun Adebayo' src={imgA} />
        <Avatar name='Ryan Florence' src={imgB} />
        <Avatar name='Kent Dodds' src='https://bit.ly/kent-c-dodds' />
        <Avatar name='Prosper Otemuyiwa' src='https://bit.ly/prosper-baba' />
        <Avatar name='Christian Nwamba' src='https://bit.ly/code-beast' />
      </AvatarGroup>
    </Flex>
  )
}

export { PackagePreview }
