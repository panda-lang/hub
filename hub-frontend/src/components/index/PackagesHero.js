import { Box, Flex, Heading, Input  } from "@chakra-ui/react"
import { PackagePreview } from 'components/index/PackagePreview'

const Category = props => {
  return (
    <Box
      paddingX="12px"
      paddingY="5px"
      cursor="pointer"
      fontWeight="bold"
      fontSize="0.9rem"
      height="2rem"
      borderRadius="none"
      {...props}
    >
      {props.children}
    </Box>
  )
}

const PackagesHero = props => {
  return (
    <Box
      maxWidth="1280px"
      w="80vw"
      paddingX="17px"
      {...props}
    >
      <Heading fontSize="1.25rem" paddingY="27px">Packages</Heading>
      <Flex
        justifyContent="space-between"
        flexDirection={{ md: "row", base:"column" }}
      >
        <Flex flexDirection="row">
          <Category bg="blue.400" color="white">Popular</Category>
          <Category>Trending</Category>
          <Category>Latest</Category>
        </Flex>
        <Flex flexDirection="row" paddingTop={{ md: "0px", base: "17px" }}>
          <Input
            size="sm"
            placeholder="Search package" 
            marginRight="7px"
          />
          <Category minWidth="8.5rem" border="1px">
            + Add package
          </Category>
        </Flex>
      </Flex>
      <Flex
        justifyContent="space-around"
        wrap="wrap"
        marginY="21px"
        marginX="-2%"
        flexGrow="1"
      >
        <PackagePreview />
        <PackagePreview />
        <PackagePreview />
        <PackagePreview />
        <PackagePreview />
        <PackagePreview />
        <PackagePreview />
        <PackagePreview />
        <PackagePreview />
      </Flex>
    </Box>
  )
}

export default PackagesHero