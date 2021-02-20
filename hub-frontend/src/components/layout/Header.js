import { Box, Heading, Link, useColorModeValue } from '@chakra-ui/react'
import { Container, Content } from 'components/layout/Container'
import HeaderMenu from 'components/layout/HeaderMenu'
import HeaderLogin from 'components/layout/HeaderLogin'

const Header = ({ title }) => {
  const bgColor = useColorModeValue('gray.50', 'gray.900')
  const color = useColorModeValue('black', 'white')

  return (
    <Container
      zIndex='1'
      height={{ sm: '4.5rem', base: 'auto' }}
      bg={bgColor}
      color={color}
      shadow='sm'
      paddingX='37px'
    >
      <Content
        flexDirection={{ sm: 'row', base: 'column' }}
        justifyContent='space-between'
        alignItems='center'
      >
        <Box width={{ sm: '100px', base: 'auto' }} paddingY={{ sm: '0px', base: '7px' }}>
          <Link href='/' _focus={{ outline: 0 }}>
            <Heading fontSize='1.5rem' paddingRight='0px'>{title}</Heading>
          </Link>
        </Box>
        <HeaderMenu paddingY={{ sm: '0px', base: '7px' }} />
        <HeaderLogin paddingY={{ sm: '0px', base: '7px' }} />
      </Content>
    </Container>
  )
}

Header.defaultProps = {
  title: 'Hub'
}

export default Header