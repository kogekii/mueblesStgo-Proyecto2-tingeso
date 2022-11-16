import React from "react";
import { Link } from "react-router-dom";

class Sidebar extends React.Component{
    render(){
        return(
            <div className="sidebar" >
                <h1>MueblesStgo</h1>
                <Link><i class="bi bi-people-fill"></i> Empleados</Link>
                <Link><i class="bi bi-clock"></i> Reloj Control</Link>
                <Link><i class="bi bi-envelope"></i> Correo</Link>
            </div>
        )
    }
}

export default Sidebar;
