import React from 'react';
import ReactDOM from 'react-dom/client';
import './index.css';
import App from './App';
import ClockComponent from './components/ClockComponent';
import EmployeeComponent from './components/EmployeeComponent';
import reportWebVitals from './reportWebVitals';
import SalaryComponent from './components/SalaryComponent';
import { BrowserRouter, Route, Routes} from 'react-router-dom';
import Login from './components/Login';
const root = ReactDOM.createRoot(document.getElementById('root'));


root.render(
  <BrowserRouter>
    <Routes>
          <Route path='/login' element={<Login/>}/>
          <Route path='/' element={<App/>}/> 
          <Route path='/clock' element={<ClockComponent/>}/>
          <Route path='/employee' element={<EmployeeComponent/>}/>
          <Route path='/salary' element={<SalaryComponent/>}/>
        </Routes>
  </BrowserRouter>
);

// If you want to start measuring performance in your app, pass a function
// to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals
reportWebVitals();
