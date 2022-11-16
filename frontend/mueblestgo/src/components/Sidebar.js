import React from "react";
import { Link } from "react-router-dom";

class Sidebar extends React.Component{
    render(){
        return(
            <div className="sidebar" >
                <h1>MueblesStgo</h1>
                <Link>Empleados</Link>
                <Link>Reloj Control</Link>
                <Link>Correo</Link>
            </div>
        )
    }
}

export default Sidebar;
