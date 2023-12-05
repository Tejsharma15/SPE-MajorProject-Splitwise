// App.js
import React from 'react';
import { BrowserRouter as Router, Routes, Route, Link } from 'react-router-dom';
import Bills from './Bills';
import Login from './Login';
import Register from './Register';
import Header from './components/Header';

function App() {
  return (
    <Router>
      <div>
        <Header />
        <nav>
        <ul>
            <li><Link to="/">Home</Link></li>
            <li><Link to="/bills">Bills</Link></li>
            <li><Link to="/login">Login</Link></li>
            <li><Link to="/register">Register</Link></li>
          </ul>
        </nav>

        <Routes>
          <Route path="/" element={<Home />} />
          <Route path="/bills" element={<Bills />} />
          <Route path="/login" element={<Login />} />
          <Route path="/register" element={<Register />} />
        </Routes>
      </div>
    </Router>
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
