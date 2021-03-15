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

import { useColorMode, Switch } from '@chakra-ui/react'

const ThemeSwitch = (props) => {
  const { colorMode, toggleColorMode } = useColorMode()
  const isDark = colorMode === 'dark'
  return (
    <Switch
      color="blue.500"
      size="md"
      isChecked={isDark}
      onChange={toggleColorMode}
      {...props}
    />
  )
}

export default ThemeSwitch
