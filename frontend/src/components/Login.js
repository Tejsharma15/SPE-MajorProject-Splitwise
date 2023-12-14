import React, { useState } from 'react';
import { Box, Input, InputGroup, InputRightElement, Button, FormErrorMessage, Heading, Spacer } from '@chakra-ui/react';
import { useNavigate } from 'react-router-dom';

function Login() {
    const [email, setEmail] = useState('');
    const [password, setPassword] = useState('');
    const navigate=useNavigate();
    const handleSubmit = (e) => {
      e.preventDefault();
      navigate("/")
      console.log('Login submitted:', { email, password });
    };
  
    return (
      <Box display='flex' flexDirection='column' alignItems='center' flexGrow='1'>
        <Box boxShadow='dark-lg' p='6' rounded='md' bg='teal.100' alignSelf='center' mt='4'>

        <Heading as='h3'> Login To Your Account</Heading>
        <Box display='flex' flexDirection='column' as="form" onSubmit={handleSubmit} alignSelf='center' mt='5' >
        <InputGroup mb={4}>
          <Input border='solid'
            borderColor='black'
            placeholder="Email"
            type="email"
            value={email}
            onChange={(e) => setEmail(e.target.value)}
            />
        </InputGroup>
        <InputGroup mb={4}>
          <Input border='solid'
            borderColor='black'
            placeholder="Password"
            type="password"
            value={password}
            onChange={(e) => setPassword(e.target.value)}
            />
        </InputGroup>
        { /* Add conditional rendering for password length error message */ }
        <FormErrorMessage>Password must be at least 8 characters long.</FormErrorMessage>
        <Button type="submit" colorScheme="teal" color="black">Login</Button>
        </Box>
        </Box>
      </Box>
  );
}

export default Login;
