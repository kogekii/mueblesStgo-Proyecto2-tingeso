import { Route, Routes, Navigate} from 'react-router-dom';
import './App.css';
import Inicio from './components/inicio';
import ClockComponent from './components/ClockComponent';
import EmployeeComponent from './components/EmployeeComponent';
import SalaryComponent from './components/SalaryComponent';
import LoginComponent from './components/LoginComponent';
import React from 'react';

export default class App extends React.Component{
  constructor(){
    super();
    this.state={
      loged:localStorage.getItem('login')
    }
  }
  render(){
    return(
      <div className='App'>
        <Routes>
        <Route path='/login' element={<LoginComponent/>}/>
          <Route path='/' element={ this.state.loged !== 'true'? <Inicio/>:<Navigate replace to={"/login"} />}/>
          <Route path='/clock' element={<ClockComponent/>}/>
          <Route path='/employee' element={<EmployeeComponent/>}/>
          <Route path='/salary' element={<SalaryComponent/>}/>
        </Routes>
      </div>
    )
  }
}
