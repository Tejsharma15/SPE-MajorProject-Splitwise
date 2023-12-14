import {React,useState,useEffect} from 'react';
import { Box, Heading, List, ListItem, Text, Button, InputGroup, Input } from '@chakra-ui/react';
import { useNavigate } from 'react-router-dom';
import { SmallAddIcon } from '@chakra-ui/icons';
function ExpenseList({ expenses, onEdit, onDelete }) {
  return (
    <List>
      {expenses.map((expense) => (
        <ListItem key={expense.id}>
          <Box display="flex" justifyContent="space-between">
            <Text>{expense.name}</Text>
            <Text>{expense.amount}</Text>
          </Box>
          <Box>
            <Button size="sm" colorScheme="teal" onClick={() => onEdit(expense)}>Edit</Button>
            <Button size="sm" colorScheme="red" variant="outline" onClick={() => onDelete(expense.id)}>Delete</Button>
          </Box>
        </ListItem>
      ))}
    </List>
  );
}
function AddExpenseForm({ onSubmit }) {
  const [name, setName] = useState("");
  const [amount, setAmount] = useState(0);

  const handleSubmit = (e) => {
    e.preventDefault();
    onSubmit({ name, amount });
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

function ExpenseTracker({user}) {
  const [expenses, setExpenses] = useState([]); // Array to store expenses
  const navigate=useNavigate();
  console.log(user)
  useEffect(()=>{
    if(user===null || user===undefined){
      navigate("/login");
    }
    const fetchExpenses=()=>{
      let expense;
      setExpenses(expense);
    }
    // fetchExpenses();
  },[user]);
  const handleAddExpense = (newExpense) => {
    // Update state with new expense
    setExpenses([...expenses, newExpense]);
  };

  const handleEditExpense = (updatedExpense) => {
    // Update specific expense in state
    const updatedExpenses = expenses.map(expense => expense.id === updatedExpense.id ? updatedExpense : expense);
    setExpenses(updatedExpenses);
  };

  const handleDeleteExpense = (id) => {
    // Update state by filtering out deleted expense
    setExpenses(expenses.filter(expense => expense.id !== id));
  };

  return (
    <Box display="flex" flexDirection="row" flexGrow={1} mt="3" ms="10">
      {/* Expense list on the left */}
      <Box p={4} backgroundColor="papayawhite" boxShadow='lg' m='2' rounded="md" w="65%">
        <Heading as="h2">Your Expenses</Heading>
        <ExpenseList expenses={expenses} onEdit={handleEditExpense} onDelete={handleDeleteExpense} />
      </Box>
      {/* Add expense form on the right */}
      <Box flexDirection='column' alignItems="center" p={4} color="teal.700" bg="teal.100" rounded="md" boxShadow='lg' m='2' w="25%">
        <Heading as="h4" m={3}>Add Expense</Heading>
        <AddExpenseForm onSubmit={handleAddExpense} />
      </Box>
    </Box>
  );
}


export default ExpenseTracker;
