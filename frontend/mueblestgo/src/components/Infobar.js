import React from "react";
import { Navigate } from "react-router-dom";
import LoginService from '../service/LoginService'
class Infobar extends React.Component{
    constructor(){
        super();
        this.state = {
            employee:localStorage.getItem('rut')
        }
    }

    render(){
        return(
            <div className="infobar" >
                <h1>Welcome... {this.state.employee}</h1>
                <button onClick={LoginService.logOut}>Log Out</button>
            </div>
        )
    }
}

export default Infobar;