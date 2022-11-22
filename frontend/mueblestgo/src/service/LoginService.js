import axios from 'axios';
    function savetoken(token){
      localStorage.setItem('token' ,token)
      localStorage.setItem('logeed', true)
      return;
    }

    function setRole(){
        localStorage.setItem('role', "user")
        return;
    }
    function login(user, pass){
        var qs = require('qs');
        axios.post('http://host.docker.internal:8080/realms/mueblesstgo/protocol/openid-connect/token',qs.stringify({
            'username': user,
            'password': pass,
            'grant_type': 'password',
            'client_id': 'myclient'
        }),{headers: {
            'Content-Type': 'application/x-www-form-urlencoded'
        }}).then(res => {
            localStorage.setItem('token', res.data.access_token);
            localStorage.setItem('rut', user);
            localStorage.setItem('isLogged', "true");
        })
    }

    function logOut(){
        localStorage.clear()
        localStorage.setItem('isLogged', "false")
        return;
    }


export default {logOut, login, savetoken, setRole};