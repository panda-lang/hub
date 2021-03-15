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
} from '@chakra-ui/react'
import { useGitHub } from '../../lib/useGitHub'
import Link from 'next/link'
import { AddIcon } from '@chakra-ui/icons'
import { FaTruckMonster } from 'react-icons/fa'

const PackageModal = (props) => {
  const color = useColorModeValue('black', 'white')

  const [repositories, setRepositories] = useState()
  const toast = useToast()
  const login = props.login

  const tableScheme = useColorModeValue('blackAlpha', 'whiteAlpha')
  const { isOpen, onClose } = useDisclosure({ defaultIsOpen: FaTruckMonster })

  if (!repositories) {
    useGitHub(`/users/${login}/repos`)
      .then((response) => {
        console.log(response)
        setRepositories(response)
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
    <Modal isOpen="true" isOpen={isOpen} onClose={onClose} size="2xl">
      <ModalOverlay />
      <ModalContent>
        <ModalHeader color={color}>Register package</ModalHeader>
        <ModalCloseButton />
        <ModalBody>
          <Table variant="simple" color={color} colorScheme={tableScheme}>
            <TableCaption>Available public repositories</TableCaption>
            <Thead>
              <Tr>
                <Th>Name</Th>
                <Th>Link</Th>
                <Th>Action</Th>
              </Tr>
            </Thead>
            <Tbody>
              {(repositories || []).map((repository) => {
                return (
                  <Tr key={repository.id}>
                    <Td>{repository.name}</Td>
                    <Td>
                      <Link href={repository.html_url}>
                        {`github.com/${repository.full_name}`}
                      </Link>
                    </Td>
                    <Td>
                      <ButtonGroup size="sm" isAttached variant="outline">
                        <IconButton
                          aria-label="Add to friends"
                          icon={<AddIcon />}
                        />
                      </ButtonGroup>
                    </Td>
                  </Tr>
                )
              })}
            </Tbody>
          </Table>
        </ModalBody>
        <ModalFooter>
          <Button colorScheme="blue" mr={3} onClick={onClose}>
            Close
          </Button>
        </ModalFooter>
      </ModalContent>
    </Modal>
  )
}

export default PackageModal
