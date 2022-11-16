import { Route, Routes, Navigate} from 'react-router-dom';
import './App.css';
import Inicio from './components/inicio';
import ClockComponent from './components/ClockComponent';
import EmployeeComponent from './components/EmployeeComponent';
import SalaryComponent from './components/SalaryComponent';
import LoginComponent from './components/LoginComponent';

export default function App(){
    return(
      <div className='App'>
        <Routes>
        <Route path='/login' element={<LoginComponent/>}/>
          <Route path='/' element={ localStorage.getItem('token') !== ''? <Inicio/>:<Navigate replace to={"/login"} />}/>
          <Route path='/clock' element={<ClockComponent/>}/>
          <Route path='/employee' element={<EmployeeComponent/>}/>
          <Route path='/salary' element={<SalaryComponent/>}/>
        </Routes>
      </div>
    )
}
