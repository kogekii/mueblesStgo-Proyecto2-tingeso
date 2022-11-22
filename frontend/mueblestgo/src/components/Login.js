import React,{ useState } from "react";
import LoginService from "../service/LoginService";
import {useNavigate, Navigate} from "react-router-dom";

export default function Login(){
    const [username, setUsername] = useState('');
    const [password, setPassword] = useState('');
    const [isLogged, setIsLogged] = useState('false');
    const navigate = useNavigate()
    React.useEffect(()=>{
      if(isLogged === "true"){
        console.log("logged")
        // navigate('/');
      }
    },[isLogged]);
    const handlelogin =  (event) => {
      
        event.preventDefault();
        LoginService.login(
          username,
          password
        );
        console.log(localStorage.getItem('isLogged'));
        setIsLogged(localStorage.getItem('isLogged'));
        setUsername('');
        setPassword('');
    };

    
    // if (localStorage.getItem('isLogged') === "true"){
    //     return <Navigate to="/"/>
    // }
    return (
        <div>
          <div className="card cartalogin">
            <div className="card-body">
              <h1 className="card-title">Login</h1>
              <form onSubmit={handlelogin}>
                <div>
                  <label className='form-label mb-3'>Usuario</label>
                  <input
                  className='form-control'
                  type="text"
                  value={username}
                  name="username"
                  placeholder="username"
                onChange={({ target }) => setUsername(target.value)}
                />
                </div>
                <div className='mb-3'>
                <label className='form-label mb-3'>Contraseña</label>
                <input
                className='form-control'
                  type="password"
                  value={password}
                  name="password"
                  placeholder="password"
                  onChange={({ target }) => setPassword(target.value)}
                />
                </div>
                <button className='btn btn-primary'>login</button>
              </form>
            </div>
          </div>
        </div>
  
      );
}
