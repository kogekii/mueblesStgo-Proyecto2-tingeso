import axios from 'axios';
import  { Navigate } from 'react-router-dom'
class LoginService{

    savetoken = (token)=>{
      localStorage.setItem('token' ,token)
      localStorage.setItem('logeed', true)
    }

    setRole(){
        localStorage.setItem('role', "user")
    }
    login(user, pass){
        var qs = require('qs');
        return axios.post('http://localhost:8080/realms/mueblesstgo/protocol/openid-connect/token',qs.stringify({
            'username': user,
            'password': pass,
            'grant_type': 'password',
            'client_id': 'myclient'
        }),{headers: {
            'Content-Type': 'application/x-www-form-urlencoded'
        }}).then(res => res.data.access_token)
    }

    logOut(){
        localStorage.setItem('token' ,'')
        localStorage.setItem('logeed', false)
        return(<Navigate to="/login"/>)
    }
}

export default new LoginService()