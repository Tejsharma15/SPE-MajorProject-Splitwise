import {React,useRef} from 'react';
import { Heading,Box, Image, Drawer, DrawerBody, DrawerHeader, DrawerOverlay, DrawerContent, DrawerCloseButton, useDisclosure, Button, Spacer, VStack } from '@chakra-ui/react';
import { HamburgerIcon} from '@chakra-ui/icons'
import logo from "../logo.png"
import bg from "../drawerbg.jpg"
import { Link } from 'react-router-dom';
function Header() {
  const { isOpen, onOpen, onClose } = useDisclosure()
  const btnRef = useRef()
  return (
    <>

    <Drawer
    isOpen={isOpen}
    placement='left'
    onClose={onClose}
    finalFocusRef={btnRef}
    colorScheme='teal'
    backdropFilter='blur(5px) brightness(0.8)'
    >
      <DrawerOverlay color='teal'/>
      <DrawerContent color='white' backgroundImage={bg} backgroundSize='cover'>
        <DrawerCloseButton />
        <DrawerHeader>MiniSplitwise</DrawerHeader>

        <DrawerBody>
          <VStack flexDir='column' alignItems='flex-start'>
            <Link onClick={onClose} to="/">Home</Link>
            <Link onClick={onClose} to="/bills">Bills</Link>
            {/* <Link onClick={onClose} to="/">Contact</Link> */}
          </VStack>
        </DrawerBody>
      </DrawerContent>
    </Drawer>
    <Box display='flex' flexDirection='row' alignItems='center' h='100%'>
    <Button ref={btnRef} m='2' p='1' color='teal.400' backgroundColor='teal.800' onClick={onOpen}> <HamburgerIcon /></Button>
    <Link to="/"><Image boxSize='50px' objectFit='cover' borderRadius='full' color='gray' src={logo}></Image></Link>
      <Heading as="h1" p='2' fontSize="4xl">MiniSplitwise</Heading>
      <Spacer/>
      <Button as={Link} to="/login" m='2' >Login</Button>
      
    </Box>
    </>
  );
}

export default Header;
