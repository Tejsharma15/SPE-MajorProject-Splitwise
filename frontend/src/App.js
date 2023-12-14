// App.js
import React, { useEffect } from 'react';
import { Routes, Route, Link, useNavigate } from 'react-router-dom';
import ExpenseTracker from './components/ExpenseTracker';
import Login from './components/Login';
import Register from './Register';
import Header from './components/Header';
import { Grid, GridItem,Box } from "@chakra-ui/react";
import { useSelector } from 'react-redux';

function App() {
  const user=useSelector((state)=> state.user);
  const navigate=useNavigate();
  return (
    
      <Grid
        templateRows='10% 90%'
        color='teal.100'
        fontWeight='bold'
        h='100vh'
        w='100vw'
      >
      <GridItem pl='2' bg='green.600'>
        <Header ussr={user}/>
      </GridItem>
      <GridItem bg='papayawhip' color='teal.900'>
        <Box display='flex' flexDirection='column'>
          <Routes>
            <Route path="/" element={<Home user={user}/>} />
            <Route path="/trackExpense" element={<ExpenseTracker user={user}/>} />
            <Route path="/login" element={<Login />} />
            <Route path="/register" element={<Register />} />
          </Routes>
        </Box>
      </GridItem>
      </Grid>
  );
}

function Home({user}) {
  const navigate=useNavigate();
  useEffect(()=>{
    if(user===null){
      navigate("/login");
    }
  },[user]);
  return (
    <div>
      <h2>Welcome to Splitwise App</h2>
      <p>This is the home page content.</p>
    </div>
  );
}

export default App;
