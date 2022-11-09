import React, { Component, useState } from 'react';
import { Route, Routes } from 'react-router-dom';
import './App.css';
import ClockComponent from './components/ClockComponent';
import EmployeeComponent from './components/EmployeeComponent';
import Inicio from './components/inicio';
import {Navbar} from './components/navbar'
import SalaryComponent from './components/SalaryComponent';
import LoginService from './service/LoginService';

export default function App() {
  const[username, setUsername] = useState('');
  const[password, setPassword] = useState('');

  const savetoken = (token)=>{
    localStorage.setItem('token' ,token)
}
  const handlelogin = async(event) => {
    event.preventDefault()
    const token = await LoginService.login(username, password)
    savetoken(token)
    setUsername('')
    setPassword('')
  }
  return(
    <div className='App'>
      <Navbar/>
      <form onSubmit={handlelogin}>
        <input
          type='text'
          value={username}
          name='username'
          placeholder='username'
          onChange={({target})=>setUsername(target.value)}/>
        <input 
          type='password'
          value={password}
          name='password'
          placeholder='password'
          onChange={({target})=>setPassword(target.value)}/>
          <button>login</button>
      </form>
      <button onClick={LoginService.logOut}>logout</button>
      <Routes>
        <Route path='/' element={<Inicio/>}/>
        <Route path='/clock' element={<ClockComponent/>}/>
        <Route path='/employee' element={<EmployeeComponent/>}/>
        <Route path='/salary' element={<SalaryComponent/>}/>
      </Routes>
    </div>
  )
}
