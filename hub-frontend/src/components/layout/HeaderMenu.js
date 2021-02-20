import { Flex, Link } from '@chakra-ui/react'

const MenuItem = props => {
  return (
    <Link
      href={props.href}
      fontWeight='bold'
      paddingX='13px'
      _focus={{ outline: 0 }}
      {...props}
    >
      {props.label}
    </Link>
  )
}

const HeaderMenu = props => {
  return (
    <Flex {...props}>
      <MenuItem label='About' href='/about' />
      <MenuItem label='Docs' href='/docs' />
      <MenuItem label='Explore' href='/explore' />
      <MenuItem label='Support' href='https://panda-lang.org/support/' />
    </Flex>
  )
}

export default HeaderMenu