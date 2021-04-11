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

  const [packages, setPackages] = useState()
  const toast = useToast()
  const login = props.login

  if (!packages) {
    useClient(`GET /repositories/${login}`)
      .then((response) => setPackages(response))
      .catch((error) =>
        toast({
          title: 'Cannot fetch your repositories',
          description: error.message,
          status: 'error',
        })
    )

    return <div/>
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
              {packages.map((pkg) => {
                return <PackageEntry key={pkg._id} pkg={pkg} />
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

const PackageEntry = ({ pkg }) => {
  const repository = pkg.repository
  const [registered, setRegistered] = useState(pkg.registered)
  const [icon, setIcon] = useState(registered ? <DeleteIcon /> : <AddIcon />)
  const { token } = useAuth()
  const toast = useToast()

  const registerPackage = () => {
    setIcon(<SpinnerIcon />)

    useClient(`${registered ? 'DELETE' : 'POST'} /package/${repository.full_name}`, token)
      .then((response) => {
        pkg.registered = !registered
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
        <Link href={`https://github.com/${repository.full_name}`}>
          {`github.com/${repository.full_name}`}
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
