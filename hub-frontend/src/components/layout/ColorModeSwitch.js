import { useColorMode, Switch } from '@chakra-ui/react'

const ColorModeSwitch = props => {
  const { colorMode, toggleColorMode } = useColorMode()
  const isDark = colorMode === 'dark'
  return (
    <Switch
      color='blue.500'
      size="md"
      isChecked={isDark}
      onChange={toggleColorMode}
      {...props}
    />
  )
}

export default ColorModeSwitch
