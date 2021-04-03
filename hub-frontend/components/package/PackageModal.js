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

import { useEffect, useState } from 'react'
import {
  Text,
  Button,
  Flex,
  Modal,
  ModalContent,
  ModalFooter,
  ModalHeader,
  ModalOverlay,
  useColorModeValue,
  useDisclosure,
  useToast,
  Spinner,
  Table,
  TableCaption,
  Thead,
  Tr,
  Th,
  Tbody,
  Td,
  ButtonGroup,
  IconButton,
  ModalBody,
  ModalCloseButton,
  Link,
} from '@chakra-ui/react'
import { AddIcon, DeleteIcon, SpinnerIcon } from '@chakra-ui/icons'
import { useClient } from '../../lib/useClient'
import { useAuth } from '../AuthProvider'

const PackageModal = (props) => {
  const color = useColorModeValue('black', 'white')
  const tableScheme = useColorModeValue('blackAlpha', 'whiteAlpha')

  const [repositories, setRepositories] = useState()
  const toast = useToast()
  const login = props.login

  if (!repositories) {
    useClient(`GET /repositories/${login}`)
      .then((response) => setRepositories(response))
      .catch((error) =>
        toast({
          title: 'Cannot fetch your repositories',
          description: error.message,
          status: 'error',
        })
    )
    
    return (
      <Flex justifyContent="center">
        <Spinner color={color} />
      </Flex>
    )
  }

  return (
    <Modal isOpen={props.isOpen} onClose={props.onClose} size="2xl">
      <ModalOverlay />
      <ModalContent>
        <ModalHeader color={color} textAlign="center">
          Register package
        </ModalHeader>
        <ModalBody>
          <Table variant="simple" color={color} colorScheme={tableScheme}>
            <Thead>
              <Tr>
                <Th>Name</Th>
                <Th>Link</Th>
                <Th>Action</Th>
              </Tr>
            </Thead>
            <Tbody>
              {repositories.map((repository) => {
                return <PackageEntry key={repository._id} repository={repository} />
              })}
            </Tbody>
            <TableCaption>Available public repositories</TableCaption>
          </Table>
        </ModalBody>
        <ModalFooter>
          <Button colorScheme="blue" mr={3} onClick={props.onClose}>
            Close
          </Button>
        </ModalFooter>
      </ModalContent>
    </Modal>
  )
}

const PackageEntry = (props) => {
  const repository = props.repository
  const [registered, setRegistered] = useState(repository.registered)
  const [icon, setIcon] = useState(registered ? <DeleteIcon /> : <AddIcon />)
  const { token } = useAuth()

  const registerPackage = () => {
    setIcon(<SpinnerIcon />)

    useClient(`${registered ? 'DELETE' : 'POST'} /package/${repository.fullName}`, token)
      .then((response) => {
        repository.registered = !registered
        setIcon(!registered ? <DeleteIcon /> : <AddIcon />)
        setRegistered(!registered)
      })
      .catch((error) =>
        toast({
          title: 'Cannot fetch your repositories',
          description: error.message,
          status: 'error',
        })
      )
  }

  return (
    <Tr>
      <Td>{repository.name}</Td>
      <Td>
        <Link href={`https://github.com/${repository.fullName}`}>
          {`github.com/${repository.fullName}`}
        </Link>
      </Td>
      <Td>
        <ButtonGroup size="sm" isAttached variant="outline">
          <IconButton
            repository={repository}
            aria-label="Add to friends"
            icon={icon}
            onClick={registerPackage}
          />
        </ButtonGroup>
      </Td>
    </Tr>
  )
}

export default PackageModal
