import {React,useState,useEffect} from 'react';
import { Box, Heading, Grid, Text, Button, InputGroup, Input, Card,CardFooter,CardHeader, IconButton } from '@chakra-ui/react';
import { useNavigate } from 'react-router-dom';
import { SmallAddIcon,EditIcon,DeleteIcon } from '@chakra-ui/icons';

function ExpenseList({ expenses, onEdit, onDelete }) {
  return (
    <Grid gap={4} mb={4} templateColumns='repeat(3, 1fr)'>
      {expenses.map((expense) => (
        <Card key={expense.billId} bg="papayawhip" >
        <CardHeader>
          <Heading as="h3" size="sm">
            {expense.billName}
          </Heading>
          <Text fontSize="sm">
            {expense.amount}
          </Text>
        </CardHeader>
        <CardFooter>
          <Box display="flex" flexDirection='row' alignItems='center' w="100%" gap={2}>
            <IconButton
              icon={<EditIcon />}
              colorScheme="teal"
              size="sm"
              onClick={() => onEdit(expense)}
              alignSelf='flex-start'
              w="50%"
            />
            <IconButton
              icon={<DeleteIcon />}
              colorScheme="red"
              size="sm"
              variant="outline"
              onClick={() => onDelete(expense.billId)}
              alignSelf='flex-end'
              w="50%"
            />
          </Box>
        </CardFooter>
      </Card>
      ))}
    </Grid>
  );
}
function AddExpenseForm({ onSubmit }) {
  const [name, setName] = useState("");
  const [amount, setAmount] = useState(0);

  const handleSubmit = (e) => {
    e.preventDefault();
    onSubmit(e);
    setName("");
    setAmount(0);
  };

  return (
    <Box as="form" flexDirection='column' alignItems="center" color="teal.700" onSubmit={handleSubmit} p="2">
      <InputGroup>
        <Input placeholder="Expense Name" borderColor="black" m="2" value={name} onChange={(e) => setName(e.target.value)} />
      </InputGroup>
      <InputGroup>
        <Input type="number" placeholder="Amount" borderColor="gray" m="2" value={amount} onChange={(e) => setAmount(e.target.value)} />
      </InputGroup>
      <Button leftIcon={<SmallAddIcon/>} type="submit" colorScheme="teal" m="2" size="lg">Add Expense</Button>
    </Box>
  );
}

function ExpenseTracker({user,jwt}) {
  const [expenses, setExpenses] = useState([]); // Array to store expenses
  const navigate=useNavigate();
  // console.log(user)
  useEffect(()=>{
    if(user===null || user===undefined){
      navigate("/login");
    }
    const fetchExpenses=async()=>{
      await fetch(`http://localhost:8081/personalBills/getBillByUser/${user}`,{
      method: 'GET',
      headers: {
        'Content-Type': 'application/json',
        Authorization: `Bearer ${jwt}` 
      }
    })
    .then((response) => {
      if (!response.ok) {
        throw new Error('Network response was not ok.');
      }
      return response.json();
    })
    .then((data) => {
      // console.log(data); // Log the response data here
      setExpenses(data);
    })
    .catch((err) => {
      console.error('Error:', err);
    });
    }
    fetchExpenses();
  },[user,navigate,jwt]);
  const handleAddExpense = async (newExpense) => {
    // Update state with new expense
    let ret=-1
    const expenseData={
      "billName": newExpense.target[0].value,
      "amount": newExpense.target[1].value,
      "email": user
    }
    // console.log(JSON.stringify(expenseData))
    await fetch('http://localhost:8081/personalBills/addBills',{
      method: 'POST',
      headers: {
        'Content-Type': 'application/json',
        Authorization: `Bearer ${jwt}` 
      },
      body: JSON.stringify(expenseData)
    })
    .then((response) => {
      if (!response.ok) {
        throw new Error('Network response was not ok.');
      }
      return response.json();
    })
    .then((data) => {
      console.log(data); // Log the response data here
      expenseData["billId"]=data;
      ret = 0;
    })
    .catch((err) => {
      ret = -1;
      console.error('Error:', err);
    });


    if(ret===0) setExpenses([...expenses, {"billName": expenseData.billName, "amount": expenseData.amount, "billId": expenseData.billId}]);
  };

  const handleEditExpense = (updatedExpense) => {
    // Update specific expense in state
    const updatedExpenses = expenses.map(expense => expense.id === updatedExpense.id ? updatedExpense : expense);
    setExpenses(updatedExpenses);
  };

  const handleDeleteExpense = async(event) => {
    // Update state by filtering out deleted expense
    // console.log(event)
    await fetch(`http://localhost:8081/personalBills/deleteByBillId/${event}`,{
      method: 'DELETE',
      headers: {
        'Content-Type': 'application/json',
        Authorization: `Bearer ${jwt}` 
      }
    })
    .then((response) => {
      if (!response.ok) {
        throw new Error('Network response was not ok.');
      }
      return response;
    })
    .then((data) => {
      // console.log(data); // Log the response data here
      setExpenses(expenses.filter(expense => expense.billId !== event));
    })
    .catch((err) => {
      console.error('Error:', err);
      alert("Couldn't delete!")
    });
  };

  return (
    <Box display="flex" flexDirection="row" flexGrow={1} mt="3" ms="10">
      {/* Expense list on the left */}
      <Box p={4} backgroundColor="papayawhite" boxShadow='lg' m='2' rounded="md" w="65%">
        <Heading as="h2">Your Expenses</Heading>
        <ExpenseList expenses={expenses} onEdit={handleEditExpense} onDelete={handleDeleteExpense} />
      </Box>
      {/* Add expense form on the right */}
      <Box flexDirection='column' alignItems="center" p={4} color="teal.700" bg="teal.100" rounded="md" boxShadow='lg' m='2' w="25%" maxH='320'>
        <Heading as="h4" m={3}>Add Expense</Heading>
        <AddExpenseForm onSubmit={handleAddExpense} />
      </Box>
    </Box>
  );
}


export default ExpenseTracker;
