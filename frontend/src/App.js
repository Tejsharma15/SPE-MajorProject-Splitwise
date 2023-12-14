// App.js
import React from 'react';
import { BrowserRouter as Router, Routes, Route, Link } from 'react-router-dom';
import Bills from './Bills';
import Login from './components/Login';
import Register from './Register';
import Header from './components/Header';
import { ChakraProvider, Grid, GridItem,Box } from "@chakra-ui/react";

function App() {
  return (
    <ChakraProvider>
      <Router>
      <Grid
        templateRows='10% 90%'
        color='teal.100'
        fontWeight='bold'
        h='100vh'
        w='100vw'
      >
      <GridItem pl='2' bg='green.600'>
        <Header />
      </GridItem>
      <GridItem bg='papayawhip' color='teal.900'>
        <Box display='flex' flexDirection='column'>
          <Routes>
            <Route path="/" element={<Home />} />
            <Route path="/bills" element={<Bills />} />
            <Route path="/login" element={<Login />} />
            <Route path="/register" element={<Register />} />
          </Routes>
        </Box>
      </GridItem>
      </Grid>
      </Router>
    </ChakraProvider>
  );
}

function Home() {
  return (
    <div>
      <h2>Welcome to Splitwise App</h2>
      <p>This is the home page content.</p>
    </div>
  );
}

export default App;
